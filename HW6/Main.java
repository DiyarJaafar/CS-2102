public class Main {
    public static void main(String[] args) {
        VotingData vd = new VotingData();
        PollingDevice pd = new PollingDevice(vd);
        pd.screen();

    }
}