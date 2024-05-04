import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame frame;
    private JPanel menuPanel;
    private JButton songsButton, playlistButton, queueButton, selectFolderButton;
    private JPanel contentPanel;
    private JLabel songsSubHeader;

    public View() {
        createFrame();
        createMenuPanel();
        createContentPanel(); 
        handleSongsButtonClick();
        frame.setVisible(true);

    }

    private void handleSongsButtonClick() {
        Component songsContent = createSongsContent();
        setContentPane(songsContent);
    }


    public void createFrame() {
        frame = new JFrame("Music Player");
        frame.setLayout(new BorderLayout());
        frame.setSize(900, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createMenuPanel() {
        menuPanel = new JPanel();
        menuPanel.setBackground(Color.blue);
        menuPanel.setPreferredSize(new Dimension(300, 550));
        menuPanel.setLayout(new FlowLayout());

        songsButton = new JButton("Songs");
        playlistButton = new JButton("Playlist Button");
        queueButton = new JButton("Queue Button");

        menuPanel.add(songsButton);
        menuPanel.add(playlistButton);
        menuPanel.add(queueButton);

        frame.add(menuPanel, BorderLayout.WEST);
    }

    public void createContentPanel() {
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        frame.add(contentPanel, BorderLayout.CENTER);
    }

    public void setContentPane(Component component) {
        contentPanel.removeAll();
        contentPanel.add(component, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public JButton getSongsBtn() {
        return songsButton;
    }

    public JButton getPlaylistsBtn() {
        return playlistButton;
    }

    public JButton getQueueBtn() {
        return queueButton;
    }


    public JButton getSelectFolderBtn() {
        return selectFolderButton;
    }


    public Component createSongsContent() {
        JPanel panel = new JPanel();

        JLabel songsHeader = new JLabel("Songs");
        songsSubHeader = new JLabel("No Music In Selected Directory");
        selectFolderButton = new JButton("Select Folder"); 

        setupSelectFolderButtonListener();

        panel.add(songsHeader);
        panel.add(songsSubHeader);
        panel.add(selectFolderButton);
        panel.setBackground(Color.RED);
        return panel;
    }


    public Component createPlaylistContent() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.GREEN);
        panel.add(new JLabel("Playlist Content"));
        return panel;
    }


    public Component createQueueContent() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.PINK);
        panel.add(new JLabel("Queue Content"));
        return panel;
    }


    private void setupSelectFolderButtonListener() {
        selectFolderButton.addActionListener(e -> {
            System.out.println("Select Folder button clicked");
            
        });
    }
}
