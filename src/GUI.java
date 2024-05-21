import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.io.*;
import java.util.List;


public class GUI {
    private JFrame frame;
    private JPanel westRegionPanel, southRegionPanel, centerRegionPanel, logoPanel, searchPanel, menuPanel, timestampPanel, sliderPanel, songPanel, playbackControlsPanel;
    private JButton searchButton, prevButton, playPauseButton, nextButton, selectDirectoryButton;
    private JSlider playbackSlider;


    public GUI() {
        createFrame();
        createWestRegionPanel();
        createSouthRegionPanel();
        createCenterRegionPanel();

        
        frame.setVisible(true);
    }


    

    

    private void createFrame() {
        frame = new JFrame("Music Player");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1366, 768);
    }


    private void createWestRegionPanel() {
        westRegionPanel = new JPanel();
        westRegionPanel.setPreferredSize(new Dimension(300, 600));
        westRegionPanel.setBackground(Color.white);
        Border westRegionPanelMargin = new EmptyBorder(0, 10,0 , 0);
        westRegionPanel.setBorder(westRegionPanelMargin);


        selectDirectoryButton = new JButton("Select Folder");

        
        frame.add(westRegionPanel, BorderLayout.WEST);
        createLogoPanel();
        createSearchPanel();
        createMenuPanel();
        westRegionPanel.add(selectDirectoryButton);
    }


    private void createSouthRegionPanel() {
        southRegionPanel = new JPanel();
        southRegionPanel.setPreferredSize(new Dimension(1366, 168));
        southRegionPanel.setBackground(Color.white);

        frame.add(southRegionPanel, BorderLayout.SOUTH);
        createTimestampPanel();
        createPlaybackControlsPanel();
    }


    private void createCenterRegionPanel() {
        centerRegionPanel = new JPanel();
        centerRegionPanel.setPreferredSize(new Dimension(1066, 600));
        centerRegionPanel.setBackground(Color.green);

        frame.add(centerRegionPanel, BorderLayout.CENTER);
    }


    


    private void createLogoPanel() {
        logoPanel = new JPanel();
        logoPanel.setPreferredSize(new Dimension(300, 50));
        logoPanel.setBackground(Color.white);
        logoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        
        ImageIcon logo = new ImageIcon("resources\\logo.png");
        JLabel logoJLabel = new JLabel(logo);

        JLabel logoHeader = new JLabel("Music Player");
        logoHeader.setFont(new Font("Inter", Font.BOLD, 24));

        logoPanel.add(logoJLabel);
        logoPanel.add(logoHeader);
        westRegionPanel.add(logoPanel);
    }


    private void createSearchPanel() {
        searchPanel = new JPanel();
        searchPanel.setPreferredSize(new Dimension(300, 50));
        searchPanel.setBackground(Color.WHITE);
        searchPanel.setLayout(new FlowLayout(FlowLayout.LEFT));


        JTextField searchBar = new JTextField(15);
        searchButton = new JButton("Search");

        searchPanel.add(searchBar);
        searchPanel.add(searchButton);
        westRegionPanel.add(searchPanel);
    }


    private void createMenuPanel() {
        menuPanel = new JPanel();
        menuPanel.setPreferredSize(new Dimension(300, 100));
        menuPanel.setBackground(Color.red);
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        Border menuPanelMargin = new EmptyBorder(0, 5,0 , 0);
        menuPanel.setBorder(menuPanelMargin);

        JLabel homeLabel = new JLabel("Home");
        homeLabel.setFont(new Font("Inter", Font.PLAIN, 24));

        JLabel yourLibLabel = new JLabel("Your Library");
        yourLibLabel.setFont(new Font("Inter", Font.PLAIN, 24));

        menuPanel.add(homeLabel);
        menuPanel.add(yourLibLabel);
        westRegionPanel.add(menuPanel);
    }


    private void createTimestampPanel() {
        timestampPanel = new JPanel();
        timestampPanel.setPreferredSize(new Dimension(1366, 64));
        timestampPanel.setBackground(Color.white);
        timestampPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        Border timestampPanelMargin = new EmptyBorder(20,10,10,10);
        timestampPanel.setBorder(timestampPanelMargin);

        songPanel = new JPanel();
        songPanel.setBackground(Color.white);
        songPanel.setPreferredSize(new Dimension(150, 40));
        songPanel.setLayout(new BoxLayout(songPanel, BoxLayout.Y_AXIS));

        JLabel songTitle = new JLabel("Song Title");

        JLabel songArtist = new JLabel("Song Artist");

        songPanel.add(songTitle);
        songPanel.add(songArtist);
    
        JLabel currentTimestamp = new JLabel("0:00");
    
        sliderPanel = new JPanel();
        sliderPanel.setPreferredSize(new Dimension(1000, 20)); 
        sliderPanel.setLayout(new GridLayout(1, 1, 0, 0));
        sliderPanel.setBackground(Color.white);
    
        playbackSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        playbackSlider.setBackground(Color.white);
    
        sliderPanel.add(playbackSlider);
    
        JLabel totalTimestamp = new JLabel("4:00");
    
        timestampPanel.add(songPanel);
        timestampPanel.add(currentTimestamp);
        timestampPanel.add(sliderPanel);
        timestampPanel.add(totalTimestamp);
        southRegionPanel.add(timestampPanel);
    }
    

    private void createPlaybackControlsPanel() {
        playbackControlsPanel = new JPanel();
        playbackControlsPanel.setPreferredSize(new Dimension(1366, 104));
        playbackControlsPanel.setBackground(Color.white);

        ImageIcon prevButtonIcon = new ImageIcon("resources\\previous.png");
        ImageIcon playButtonIcon = new ImageIcon("resources\\play-button.png");
        ImageIcon nextButtonIcon = new ImageIcon("resources\\next-button.png");

        Dimension playbackButtonsMaxSize = new Dimension(50, 50);

        prevButton = new JButton(prevButtonIcon);
        prevButton.setMaximumSize(playbackButtonsMaxSize);
        prevButton.setBorderPainted(false);
        prevButton.setContentAreaFilled(false);
        prevButton.setMargin(new Insets(0, 0, 0, 0));

        playPauseButton = new JButton(playButtonIcon);
        playPauseButton.setMaximumSize(playbackButtonsMaxSize);
        playPauseButton.setBorderPainted(false);
        playPauseButton.setContentAreaFilled(false);
        playPauseButton.setMargin(new Insets(0, 0, 0, 0));

        nextButton = new JButton(nextButtonIcon);
        nextButton.setMaximumSize(playbackButtonsMaxSize);
        nextButton.setBorderPainted(false);
        nextButton.setContentAreaFilled(false);
        nextButton.setMargin(new Insets(0, 0, 0, 0));

        playbackControlsPanel.add(prevButton);
        playbackControlsPanel.add(playPauseButton);
        playbackControlsPanel.add(nextButton);

        southRegionPanel.add(playbackControlsPanel);
    }


    public JButton getPlayPauseButton() {
        return playPauseButton;
    }


    public JButton getSelectDirectoryButton() {
        return selectDirectoryButton;
    }
}