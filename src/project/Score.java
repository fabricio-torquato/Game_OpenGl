/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import com.sun.opengl.util.GLUT;
import com.sun.opengl.util.j2d.TextRenderer;
import java.awt.Color;
import java.awt.Font;
import javax.media.opengl.GL;

/**
 *
 * @author fabricio
 */
public class Score implements _Object3D {

    private float x;
    private float y;

    Score(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void Draw(GL gl, GLUT glut, int scorePlayer1, int scorePlayer2) {
        String textPlayer1 = "Player 1: " + Integer.toString(scorePlayer1);
        String textPlayer2 = "Player 2: " + Integer.toString(scorePlayer2);

        TextRenderer textr = new TextRenderer(new Font("SansSerif", Font.PLAIN, 18));
        textr.setColor(Color.black);
        textr.begin3DRendering();
        textr.draw3D(textPlayer1, getX(), getY(), 0.0f, 0.01f);
        textr.end3DRendering();

        textr = new TextRenderer(new Font("SansSerif", Font.PLAIN, 18));
        textr.setColor(Color.black);
        textr.begin3DRendering();
        textr.draw3D(textPlayer2, getX(), getY() - 0.5f, 0.0f, 0.01f);
        textr.end3DRendering();
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void Draw(GL gl, GLUT glut, double glTranslated, int glRotated) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void Draw(GL gl, GLUT glut, int glRotated) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
