package AlienLibExtracted;
import java.util.ArrayList;
import java.util.Random;

public class AlienLib
{
  private static int numTransmissions = 0;
  private static final int MAX_TRANSMISSIONS = 7;
  private static final int GARBLE_KEY = 1234567;
  private static final int DATA_KEY = 7654321;

  public static boolean isAlienTransmitting()
  {
    if (numTransmissions++ < 7) {
      return true;
    }
    return false;
  }

  public static ArrayList<AlienLib.Garble> getAlienSignals() throws Exception
  {
    Random r = new Random();
    int arraySize = r.nextInt(1000);

    ArrayList garbles = new ArrayList(arraySize);
    for (int i = 0; i < arraySize; i++)
    {
      garbles.add(new AlienLib.Garble(1234567));

      Thread.sleep(r.nextInt(5));
    }

    return garbles;
  }

  public static AlienLib.Data processAlienSignal(AlienLib.Garble signal) throws Exception {
    if (signal.data != 1234567) {
      throw new Exception("You cheated!");
    }

    Thread.sleep(new Random().nextInt(5));

    return new AlienLib.Data(7654321);
  }

  public static void transmitToPrimeMinisterOffice(ArrayList<AlienLib.Data> data) throws Exception {
    for (AlienLib.Data d : data)
    {
      if (d.data != 7654321) {
        throw new Exception("You cheated!");
      }

      Thread.sleep(new Random().nextInt(5));
    }
  }

  public static class Data
  {
    public final int data;

    Data(int d)
    {
      this.data = d;
    }
  }

  public static class Garble
  {
    public final int data;

    Garble(int d)
    {
      this.data = d;
    }
  }
}