package week3;

import java.io.IOException;

public class Level {
  public static void main(String[] args) {
    Encrypt.translate(new ConsoleReader(), new ConsoleWriter());
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