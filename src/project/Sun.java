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
public class Sun implements _Object3D {

    private double x, y;

    public Sun(double x, double y) {
        this.x = x;
        this.y = y;

    }

    public void Draw(GL gl, GLUT glut, double glTranslated, int glRotated) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void Draw(GL gl, GLUT glut, int glRotated) {
        gl.glPushMatrix();
        gl.glColor3f(0.99f,0.72f,0.07f);
        gl.glTranslated(this.getX(), this.getY(), 0);
        gl.glScaled(1, 1, 1);
        gl.glRotated(glRotated, 0, 1, 0);
        glut.glutSolidSphere(1, 16, 16);
        gl.glPopMatrix();

    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

}
