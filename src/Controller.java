public class Controller {
    private View view;

    public Controller(View view) {
        this.view = view;
        setupButtonListener();
    }

    private void setupButtonListener() {
        view.getSongsBtn().addActionListener(e -> {
            view.setContentPane(view.createSongsContent());
        });

        view.getPlaylistsBtn().addActionListener(e -> {
            view.setContentPane(view.createPlaylistContent());
        });

        view.getQueueBtn().addActionListener(e -> {
            view.setContentPane(view.createQueueContent());
        });
    }
}
