/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;

/**
 *
 * @author fabricio
 */
public class Stadium implements _Object3D {

    private int x, y;

    public Stadium(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public void Draw(GL gl, GLUT glut, double glTranslated, int glRotated) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void Draw(GL gl, GLUT glut, int glRotated) {
        for (int i = 1; i <= 5; i++) {
            gl.glPushMatrix();
            gl.glColor3f(0.13f, 0.54f, 0.13f);
            gl.glTranslated(this.getX(), -4 + i, -3 - i);
            gl.glScaled(30, 3, 3);
            glut.glutSolidCube(1);
            gl.glPopMatrix();
            gl.glPushMatrix();
            gl.glColor3f(0, 0, 0);
            gl.glTranslated(this.getX(), -4 + i, -3 - i);
            gl.glScaled(30, 3, 3);
            glut.glutWireCube(1);
            gl.glPopMatrix();
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
