package impossible.oseias.com.br.impossible;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Escola on 04/07/2016.
 */
public class Impossible extends SurfaceView implements Runnable{

    private int enemyX, enemyY, enemyRadius = 50;
    private int playerX = 300, playerY = 300, playerRadius = 50;
    private double distance;
    private boolean gameover;

    private int score;

    boolean running = false;
    Thread renderThread = null;
    SurfaceHolder holder;
    Paint paint;

    public Impossible(Context context) {
        super(context);
        paint = new Paint();
        holder = getHolder();
    }
    @Override
    public void run() {
        while(running) {
            //Verifica se a tela já está pronta...
            if(!holder.getSurface().isValid())
                continue;

            //Bloqueia o canvas
            Canvas canvas = holder.lockCanvas();
            //canvas.drawColor(Color.BLACK);
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),
                    R.drawable.sky), 0, 0, null);

            //Desenha o player e o inimigo
            drawPlayer(canvas);
            drawEnemy(canvas);

            //Detecta colisão
            checkCollision(canvas);
            if(gameover) {
                stopGame(canvas);
                break;
            }

            //Atualiza o placar
            drawScore(canvas);

            // Restart e Exit
            drawButtons(canvas);

            //Atualiza e libera o canvas
            holder.unlockCanvasAndPost(canvas);
        }
    }

    public void resume(){
        running = true;
        renderThread = new Thread(this);
        renderThread.start();
    }

    //desenho do player
    private void drawPlayer(Canvas canvas) {
        paint.setColor(Color.GREEN);
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),
                R.drawable.nave), playerX - 50, playerY - 50, null);
        //canvas.drawCircle(playerX, playerY, 50, paint);
    }

    public void moveDown(int pixels) {
        playerY += pixels;
    }

    //desenho do inimigo
    private void drawEnemy(Canvas canvas) {
        paint.setColor(Color.RED);
        enemyRadius++;
        canvas.drawCircle(enemyX, enemyY, enemyRadius, paint);
    }

    //Checar a colisão do inimigo com o player
    private void checkCollision(Canvas canvas) {
        // calcula a hipotenusa
        distance = Math.pow(playerY - enemyY, 2)
                + Math.pow(playerX - enemyX, 2);
        distance = Math.sqrt(distance);
        // verifica distancia entre os raios
        if (distance <= playerRadius + enemyRadius) {
            gameover = true;
        }
    }

    //Mensagem de Game Over!
    private void stopGame(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        paint.setTextSize(100);
        canvas.drawText("GAME OVER!", 50, 150, paint);
    }

    //Aumentar o score
    public void addScore(int points) {
        score += points;
    }

    //Atualizaremos um campo na tela com o valor atual da score.
    private void drawScore(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        paint.setTextSize(50);
        canvas.drawText(String.valueOf(score), 50, 200, paint);
    }

    //Botões de Restart e Exit
    private void drawButtons(Canvas canvas) {
        //Restart
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        paint.setTextSize(30);
        canvas.drawText("Restart", 50, 300, paint);

        //Exit
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        paint.setTextSize(30);
        canvas.drawText("Exit", 50, 500, paint);
    }


    //Button Restart = Reinicialização;
    public void init() {
        enemyX = enemyY = enemyRadius = 0;
        playerX = playerY = 300;
        playerRadius = 50;
        score = 0;
        gameover = false;
    }
}
