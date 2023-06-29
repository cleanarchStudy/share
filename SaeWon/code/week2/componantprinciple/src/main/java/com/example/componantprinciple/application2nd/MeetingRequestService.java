package com.example.componantprinciple.application2nd;


/**
 * 개인 프로젝트 예시
 * 이 코드는 Project에 참여하고있는 인원들이 Meeting을 생성하는 코드임.
 * 미팅을 스케줄링하기위한 제반정보가 거의 모두 활용되는 클래스로, 굉장히 많은 의존성을 갖고있음.
 *
 * 현재 코드는 개선되지 않은 문제가 많은 코드임. */

import com.flab.quicktogether.meeting.domain.Meeting;
import com.flab.quicktogether.meeting.domain.MeetingInfo;
import com.flab.quicktogether.meeting.domain.MeetingRepository;
import com.flab.quicktogether.meeting.domain.MeetingStatus;
import com.flab.quicktogether.meeting.domain.exception.MeetingNotFoundException;
import com.flab.quicktogether.meeting.presentation.dto.MeetingRequestDto;
import com.flab.quicktogether.meeting.presentation.dto.MeetingResponseDto;
import com.flab.quicktogether.project.domain.Project;
import com.flab.quicktogether.project.exception.ProjectNotFoundException;
import com.flab.quicktogether.project.infrastructure.ProjectRepository;
import com.flab.quicktogether.project.support.post.domain.Post;
import com.flab.quicktogether.project.support.post.infrastructure.PostRepository;
import com.flab.quicktogether.timeplan.application.ScheduleService;
import com.flab.quicktogether.timeplan.domain.plan.Plan;
import com.flab.quicktogether.timeplan.domain.plan.PlanJpaRepository;
import com.flab.quicktogether.timeplan.domain.value_type.TimeBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Service
@Transactional
public class MeetingRequestService {

    /** 컴포넌트간의 주고받는 인터페이스를 명확히 정의하지 않다보니, 어떤것은 sevice, 어떤것은 repository 다양하게 의존하고있음.
     * 이는, repository사용시 비즈니스로직의 일관성 없이 호출하는것으로, 잠재적 위험성을 갖고있으므로 필요한것에 의존했다고 보기 어려움.(CRP위반) */
    private final ProjectRepository projectRepository;
    private final MeetingRepository meetingRepository;
    private final ScheduleService scheduleService;
    private final PlanJpaRepository planJpaRepository;
    private final PostRepository postRepository;

    @Autowired
    public MeetingRequestService(ProjectRepository projectRepository,
                                 MeetingRepository meetingRepository,
                                 ScheduleService scheduleService,
                                 PlanJpaRepository planJpaRepository,
                                 PostRepository postRepository) {
        this.projectRepository = projectRepository;
        this.meetingRepository = meetingRepository;
        this.scheduleService = scheduleService;
        this.planJpaRepository = planJpaRepository;
        this.postRepository = postRepository;
    }

    /** CCP 위반사례
     *  위와 함께 보면, 관리자가 미팅을 등록하지만 이것은 참가자가 미팅을 등록해달라고 요청하는 메서드임.
     *  액터가 서로 다름. 즉, 동일한 시점에 동일한 이유로 변경되는것끼리 묶여야하는 CCP위반임.  */
    public void requestRegistration(Long memberId, Long projectId, MeetingRequestDto meetingRequestDto) {
        Project project = findProject(projectId);

        MeetingInfo meetingInfo = meetingRequestDto.toMeetingInfo();

        /**
         * 미팅생성빌더가 scheduleService를 사용하는것으로, */
        Meeting meeting = Meeting.requestBuilder(memberId, project)
                .setMeetingInfo(meetingInfo)
                .validateAndBuild(scheduleService);

        //미팅 저장
        meetingRepository.save(meeting);

        //ProjectPost.json 등록
        Post post = meeting.createPost();
        postRepository.save(post);

    }


    /**
     * CCP위반*/
    public void requestModification(Long loginMemberId, Long meetingId, MeetingRequestDto meetingRequestDto) {
        Meeting meeting = findMeeting(meetingId);
        MeetingInfo meetingInfo = meetingRequestDto.toMeetingInfo();

        meeting.proposeModification(loginMemberId, meetingInfo);

        Post post = meeting.createPost();
        postRepository.save(post);


    }

    /**
     * CCP위반*/
    public void requestCancelation(Long loginMemberId, Long meetingId) {
        Meeting meeting = findMeeting(meetingId);
        meeting.proposeDeletion(loginMemberId);

    }

    private Meeting findMeeting(Long meetingId) {
        Meeting meeting = meetingRepository.findById(meetingId)
                .orElseThrow(MeetingNotFoundException::new);
        return meeting;
    }

    private Project findProject(Long projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow(ProjectNotFoundException::new);
    }

    private void verifyExisting(List<Meeting> meetingWaitingForAccepting) {
        if (meetingWaitingForAccepting.isEmpty()) {
            throw new MeetingNotFoundException();
        }
    }

    public MeetingResponseDto getMeeting(Long loginMemberId, Long meetingId, String timeZone) {
        Meeting meeting = findMeeting(meetingId);
        meeting.checkParticipant(loginMemberId);

        return MeetingResponseDto.from(meeting, timeZone);
    }


}

