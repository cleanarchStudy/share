package week6;

import java.io.IOException;

public class Detail {
  public static void main(String[] args) {
    CharReaderLoggingProxy charReaderLoggingProxy = new CharReaderLoggingProxy(new ConsoleReader());
    CharWriterLoggingProxy charWriterLoggingProxy = new CharWriterLoggingProxy(new ConsoleWriter());
    Encrypt.translate(charReaderLoggingProxy, charWriterLoggingProxy);
  }
}

//Encryption 컴포넌트(고수준)
class Encrypt {
  public static void translate(CharReader reader, CharWriter writer) {
    char c = reader.readChar();
    char translatedChar = '0';
    writer.writeChar(translatedChar);
  }
}

interface CharReader {
  char readChar();
}

interface CharWriter {
  void writeChar(char c);
}

//IO Devices 컴포넌트(저수준)
class ConsoleReader implements CharReader {

  @Override
  public char readChar() {
    try {
      return (char) System.in.read();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}

class ConsoleWriter implements CharWriter {

  @Override
  public void writeChar(char c) {
    System.out.println("c = " + c);
  }
}

//프록시 생성
class CharReaderLoggingProxy implements CharReader {

  private CharReader charReader;

  CharReaderLoggingProxy(CharReader charReader) {
    this.charReader = charReader;
  }

  @Override
  public char readChar() {
    char readChar = charReader.readChar();
    System.out.println("Logging after readChar");
    return readChar;
  }
}

class CharWriterLoggingProxy implements CharWriter {

  private CharWriter charWriter;

  CharWriterLoggingProxy(CharWriter charWriter) {
    this.charWriter = charWriter;
  }

  @Override
  public void writeChar(char c) {
    charWriter.writeChar(c);
    System.out.println("Logging after writeChar");
  }
}


