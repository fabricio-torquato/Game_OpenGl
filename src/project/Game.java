/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.GLUT;
import com.sun.opengl.util.j2d.TextRenderer;
import java.awt.Color;
import java.awt.Font;
import javax.media.opengl.GL;

/**
 *
 * @author fabricio
 */
public class Game {

    private Player player1;
    private double dplayer1 = 0.0f;
    private Player player2;
    private double dplayer2 = 0.0f;
    private Ball ball;
    private Net net;
    private Ground ground;
    private Sun sum;
    private Score score;
    private int rotation;
    private int pointPlayer1;
    private int pointPlayer2;

    public Game() {
    }

    public void StartGame() {
        dplayer2 = 0.0f;
        dplayer1 = 0.0f;
        rotation = 0;
        pointPlayer1 = 0;
        pointPlayer2 = 0;
        player1 = new Player(-2.0f);
        player2 = new Player(4.0f);
        ball = new Ball(0.0f, 2.0f, 0.2f);
        net = new Net(1, 0);
        ground = new Ground(-3, 0);
        sum = new Sun(6.2f, 4.6f);
        score = new Score(-6.5f,4.5f);
    }

    public void Draw(GL gl, GLUT glut) {
        sum.Draw(gl, glut, rotation/4);
        net.Draw(gl, glut, 0);
        ground.Draw(gl, glut, -4);
        player1.Draw(gl, glut, dplayer1, rotation);
        dplayer1 = 0.0f;
        player2.Draw(gl, glut, dplayer2, rotation);
        dplayer2 = 0.0f;
        ball.move(player1, player2, net);
        ball.Draw(gl, glut, rotation);
        int point = ball.isDeadBall();
        if (point == 1) {
            pointPlayer1++;
        } else if (point == 2) {
            pointPlayer2++;
        }
        score.Draw(gl, glut, pointPlayer1, pointPlayer2);
        rotation++;
    }

    public void Restart(GL gl, GLUT glut) {

        String text = "Press 'R' to reset the game";

        TextRenderer textr = new TextRenderer(new Font("SansSerif", Font.PLAIN, 18));
        textr.setColor(Color.GREEN);
        textr.begin3DRendering();
        textr.draw3D(text, -3.5f, 2, 0, 0.03f);
        textr.end3DRendering();
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public double getDplayer1() {
        return dplayer1;
    }

    public void setDplayer1(double dplayer1) {
        this.dplayer1 = dplayer1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public double getDplayer2() {
        return dplayer2;
    }

    public void setDplayer2(double dplayer2) {
        this.dplayer2 = dplayer2;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Net getNet() {
        return net;
    }

    public void setNet(Net net) {
        this.net = net;
    }

    public Ground getGround() {
        return ground;
    }

    public void setGround(Ground ground) {
        this.ground = ground;
    }

    public Sun getSum() {
        return sum;
    }

    public void setSum(Sun sum) {
        this.sum = sum;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public int getPointPlayer1() {
        return pointPlayer1;
    }

    public void setPointPlayer1(int pointPlayer1) {
        this.pointPlayer1 = pointPlayer1;
    }

    public int getPointPlayer2() {
        return pointPlayer2;
    }

    public void setPointPlayer2(int pointPlayer2) {
        this.pointPlayer2 = pointPlayer2;
    }

}
