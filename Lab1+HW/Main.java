public class Main 
{
  public static void main(String[] args) 
  {
    InputDevice inputDevice = new InputDevice();
    InputDevice inputDevice2 = new InputDevice();
    OutputDevice outputDevice = new OutputDevice();
    Application application = new Application(inputDevice, inputDevice2, outputDevice);

    application.run();
  }
}
