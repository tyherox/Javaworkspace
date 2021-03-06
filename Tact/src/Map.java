import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Map extends JPanel {

    public static final Color CITY = new Color(214,217,223);
    public static final Color DESERT = new Color(255,204,102);
    public static final Color DIRT_ROAD = new Color(153,102,0);
    public static final Color FOREST = new Color(0,102,0);
    public static final Color HILLS = new Color(51,153,0);
    public static final Color LAKE = new Color(0,153,153);
    public static final Color MOUNTAINS = new Color(102,102,255);
    public static final Color OCEAN = new Color(0,0,153);
    public static final Color PAVED_ROAD = new Color(51,51,0);
    public static final Color PLAINS = new Color(102,153,0);

    public static final Color[] TERRAIN = {
        /*CITY,
        DESERT,
        DIRT_ROAD,
        FOREST,
        HILLS,
        LAKE,
        MOUNTAINS,*/
        OCEAN,
        //PAVED_ROAD,
        PLAINS
    };

    public static final int NUM_ROWS = 100;
    public static final int NUM_COLS = 100;

    public static int SIZE = 0;
    public static int PREFERRED_GRID_SIZE_PIXELS;
    
    private final Color[][] terrainGrid;

    public Map(int size){
    	SIZE = size;
    	PREFERRED_GRID_SIZE_PIXELS =SIZE/NUM_ROWS;
    	System.out.println(PREFERRED_GRID_SIZE_PIXELS);
        this.terrainGrid = new Color[NUM_ROWS][NUM_COLS];
        Random r = new Random();
        
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                int randomTerrainIndex = r.nextInt(TERRAIN.length);
                Color randomColor = TERRAIN[randomTerrainIndex];
                this.terrainGrid[i][j] = randomColor;
            }
        }
        int preferredWidth = NUM_COLS * PREFERRED_GRID_SIZE_PIXELS;
        int preferredHeight = NUM_ROWS * PREFERRED_GRID_SIZE_PIXELS;
        setPreferredSize(new Dimension(preferredWidth, preferredHeight));
    }
    
    public void zoom(String z)
    {
    	if(z.equals("in"))
    	{
    		SIZE = SIZE+30;
    	}
    	else
    	{
    		SIZE = SIZE-30;
    	}
    	System.out.println("new size: " + SIZE);
    	PREFERRED_GRID_SIZE_PIXELS =SIZE/NUM_ROWS;
    	int preferredWidth = NUM_COLS * PREFERRED_GRID_SIZE_PIXELS;
        int preferredHeight = NUM_ROWS * PREFERRED_GRID_SIZE_PIXELS;
        setPreferredSize(new Dimension(preferredWidth, preferredHeight));
        revalidate();
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        // Important to call super class method
        super.paintComponent(g);
        // Clear the board
        g.clearRect(0, 0, getWidth(), getHeight());
        // Draw the grid
        int rectWidth = getWidth() / NUM_COLS;
        int rectHeight = getHeight() / NUM_ROWS;

        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                // Upper left corner of this terrain rect
                int x = i * rectWidth;
                int y = j * rectHeight;
                Color terrainColor = terrainGrid[i][j];
                g.setColor(terrainColor);
                g.fillRect(x, y, rectWidth, rectHeight);
            }
        }
    }
}