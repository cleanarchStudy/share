package repository.domain;

/**
 * repository.domain.User.
 */
public final class User {

  private Long id;

  private String email;

  private String password;

  private String name;

  private String phoneNumber;

  /**
   * 기본 생성자.
   */
  public User() {
  }

  /**
   * 회원가입 할 때 사용.
   */
  public User(String email, String password, String name, String phoneNumber) {
    this.email = email;
    this.password = password;
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

  /**
   * 보통의 경우.
   */
  public User(Long id, String email, String password, String name, String phoneNumber,
      Long addressId) {
    this.id = id;
    this.email = email;
    this.password = password;
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

  /**
   * 유저 정보 업데이트.
   */
  public void setMyAccountUpdate(String email, String name, String phoneNumber) {
    this.email = email;
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

  /**
   * changePassword(). setter + encoder.
   */
  public void changePassword(String changedPassword) {
    this.password = changedPassword;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  @Override
  public String toString() {
    return "repository.domain.User{" +
        "id=" + id +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        ", name='" + name + '\'' +
        ", phoneNumber='" + phoneNumber + '\'' +
        '}';
  }
}

