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
public class Crowd implements _Object3D {

    private int x, y;
    private int jump;
    private int time;

    public Crowd(int x, int y) {
        this.x = x;
        this.y = y;
        jump = 0;
        time = 0;

    }

    public void Draw(GL gl, GLUT glut, double glTranslated, int glRotated) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void Draw(GL gl, GLUT glut, int glRotated) {
        time++;
        if (time == 20) {
            time = 0;
            jump++;
            if (jump == 4) {
                jump = 0;
            }
        }
        for (int j = 0; j < 4; j++) {
            for (int i = 1; i <= 4; i++) {
                gl.glPushMatrix();
                gl.glColor3f(0.13f, 0.54f, 0.13f);
                gl.glTranslated(this.getX() + j + (i * 5), -1 + j, -3 - j);
                if (j == jump) {
                    gl.glTranslated(0, 1, 0);
                }
                gl.glScaled(0.4f, 0.75f, 0.45);
                glut.glutSolidSphere(1, 16, 16);
                gl.glPopMatrix();
            }
        }
//
//        for (int i = 1; i <= 5; i++) {
//            for (int j = 1; j < 5; j++) {
//                gl.glPushMatrix();
//                gl.glColor3f(0.13f, 0.54f, 0.13f);
//                gl.glTranslated(this.getX() + j, -4 + i, -3 - i);
//                gl.glScaled(1, 3, 3);
//                glut.glutSolidSphere(1, 16, 16);
//                gl.glPopMatrix();
//            }
//        }
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
