import java.io.File;
import java.util.List;

public class Controller {
    private View view;

    public Controller(View view) {
        this.view = view;
        setupMenuButtonListener();
    }

    private void setupMenuButtonListener() {
        view.getSongsBtn().addActionListener(e -> {
            if (view.areAudioFilesFound()) {
                List<File> audioFiles = view.getFoundAudioFiles();
                view.displayAudioFiles(audioFiles);
            } else {
                // Display the default songs content panel
                view.setContentPane(view.createSongsContent());
            }
        });

        view.getPlaylistsBtn().addActionListener(e -> {
            System.out.println("2");
            view.setContentPane(view.createPlaylistContent());
            System.out.println("2");
        });

        view.getQueueBtn().addActionListener(e -> {
            System.out.println("3");
            view.setContentPane(view.createQueueContent());
            System.out.println("3");
        });
    }

    
}
