public class Controller {
    private View view;

    public Controller(View view) {
        this.view = view;
        setupMenuButtonListener();
    }

    private void setupMenuButtonListener() {
        view.getSongsBtn().addActionListener(e -> {
            System.out.println("1");
            view.setContentPane(view.createSongsContent());
            System.out.println("1");
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
