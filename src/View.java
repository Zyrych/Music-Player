import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame frame;
    private JPanel menuPanel;
    private JButton songsButton, playlistButton, queueButton;
    private JPanel contentPanel;

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

    // Method to create Songs content
    public Component createSongsContent() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.RED);
        panel.add(new JLabel("Songs Content"));
        return panel;
    }

    // Method to create Playlist content
    public Component createPlaylistContent() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.GREEN);
        panel.add(new JLabel("Playlist Content"));
        return panel;
    }

    // Method to create Queue content
    public Component createQueueContent() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.PINK);
        panel.add(new JLabel("Queue Content"));
        return panel;
    }
}
