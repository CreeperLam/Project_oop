import javax.swing.JOptionPane;

public class Progress {
    private static int progress = 0;
    private static String message = "Level Completed !!!" + '\n' + "Starting next Level";
    public static void updateProgress(int num) {
        progress = progress + num;
        System.out.println(progress);
        if(progress>=150) {
           if("1".equals(LevelData.Lvl)) {
        	   JOptionPane.showMessageDialog(null,message);
               GameWindow.gw.getYard().reset();
        	   GameWindow.gw.dispose();
        	   GameWindow.gw = new GameWindow();
        	   LevelData.write("2");
            }
           else if ("2".equals(LevelData.Lvl)){
        	   JOptionPane.showMessageDialog(null,message);
               GameWindow.gw.getYard().reset();
               GameWindow.gw.dispose();
               GameWindow.gw = new GameWindow();  
               LevelData.write("3");
           }
           else {
                LevelData.write("1");
                JOptionPane.showOptionDialog(null, message, "Level Completed !!!" + '\n' + "More Levels will come soon !!!" + '\n' + "Resetting data", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Quit"}, "Quit");
                System.exit(0);
           }
           progress = 0;
        }
    }

	public static int getProgress() {
		return progress;
	}

	public static void setProgress(int progress) {
		Progress.progress = progress;
	}
}
