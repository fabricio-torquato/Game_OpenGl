package project;

import com.sun.opengl.util.Animator;
import com.sun.opengl.util.GLUT;
import com.sun.opengl.util.texture.Texture;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

/**
 * Project_robot.java <BR>
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel)
 * <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
public class Main implements GLEventListener, KeyListener {

    private Game game;

    //Informacoes sobre a luz
    float luzAmbiente[] = {0.2f, 0.2f, 0.2f, 1.0f};
    float luzDifusa[] = {1.0f, 1.0f, 1.0f, 1.0f};	   // "cor"
    float luzEspecular[] = {1.0f, 1.0f, 1.0f, 1.0f};// "brilho"
    float posicaoLuz[] = {0.0f, 50.0f, 50.0f, 1.0f};

    // Informacoes sobre o material
    float especularidade[] = {1.0f, 0.0f, 0.0f, 1.0f};
    int especMaterial = 60;
    double eqn[] = {-0.15, 0.15, 0, 0};

    /**
     * The earth texture.
     */
    private Texture earthTexture;

    GLUT glut = new GLUT();

    public static void main(String[] args) {
        Frame frame = new Frame("Soccer");
        GLCanvas canvas = new GLCanvas();

        Main main1 = new Main();
        canvas.addGLEventListener(main1);
        frame.add(canvas);
        frame.setSize(1000, 500);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                new Thread(new Runnable() {

                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });

        frame.addKeyListener(main1);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();
    }

    public void init(GLAutoDrawable drawable) {

        GL gl = drawable.getGL();

        System.err.println("INIT GL IS: " + gl.getClass().getName());

        gl.setSwapInterval(1);

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glShadeModel(GL.GL_SMOOTH);

        gl.glLightfv(GL.GL_LIGHT1, GL.GL_AMBIENT, luzAmbiente, 0);
        gl.glLightfv(GL.GL_LIGHT1, GL.GL_DIFFUSE, luzDifusa, 0);
        gl.glLightfv(GL.GL_LIGHT1, GL.GL_SPECULAR, luzEspecular, 0);
        gl.glLightfv(GL.GL_LIGHT1, GL.GL_POSITION, posicaoLuz, 0);

        gl.glEnable(GL.GL_COLOR_MATERIAL);
        gl.glEnable(GL.GL_LIGHTING);
        gl.glEnable(GL.GL_LIGHT1);
        gl.glEnable(GL.GL_DEPTH_TEST);

    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        game = new Game();
        game.StartGame();
        if (height <= 0) {

            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    @Override
    public void display(GLAutoDrawable drawable) {

        GL gl = drawable.getGL();
        gl.glEnable(GL.GL_TEXTURE_2D);
        gl.glClear(GL.GL_COLOR_BUFFER_BIT
                | GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();

        gl.glTranslated(0, -1.5f, -9);

        gl.glRotated(10, 1, 0, 0);
        if (game.getPointPlayer1() == 10 || game.getPointPlayer2() == 10) {
            game.Restart(gl, glut);
        } else {
            game.Draw(gl, glut);
        }
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    public void keyTyped(KeyEvent ke) {

    }

    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_A) {
            if (game.getPlayer1().getX() - 0.3 > -4.5) {
                game.setDplayer1(-0.5);
            }
        }
        if (ke.getKeyCode() == KeyEvent.VK_D) {
            if (game.getPlayer1().getX() + 0.3 < 0) {
                game.setDplayer1(0.5);
            }
        }
        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            if (game.getPlayer2().getX() - 0.3 > 2) {
                game.setDplayer2(-0.5);
            }
        }
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (game.getPlayer2().getX() + 0.3 < 6.5) {
                game.setDplayer2(0.5);
            }
        }
        if (ke.getKeyCode() == KeyEvent.VK_R) {
            game.StartGame();
        }
    }

    public void keyReleased(KeyEvent ke) {
    }

}
