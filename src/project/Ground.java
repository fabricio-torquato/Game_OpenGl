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
public class Ground implements _Object3D {

    private int x, y;
    private float[] rgba = {194 / 255, 178 / 255, 128 / 255};

    public Ground(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public void Draw(GL gl, GLUT glut, double glTranslated, int glRotated) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void Draw(GL gl, GLUT glut, int glRotated) {
        gl.glPushMatrix();

//        gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT, rgba, 0);
//        gl.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, rgba, 0);
//        gl.glMaterialf(GL.GL_FRONT, GL.GL_SHININESS, 0.5f);

        gl.glTranslated(this.getX(), -2, 0);
        gl.glScaled(25, 1, 5);
        gl.glRotated(glRotated, 0, 1, 0);
        glut.glutSolidCube(1);
        gl.glPopMatrix();
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
