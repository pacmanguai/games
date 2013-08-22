package es.pac.framework.implementation;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class AndroidFastRenderView extends SurfaceView implements Runnable {
	
	// desired fps
	private final static int    MAX_FPS = 50;   
	// maximum number of frames to be skipped
	private final static int    MAX_FRAME_SKIPS = 5;    
	// the frame period
	private final static int    FRAME_PERIOD = 1000 / MAX_FPS; 
	
	AndroidGame game;
	Bitmap framebuffer;
	Thread renderThread = null;
	SurfaceHolder holder;
	volatile boolean running = false;

	public AndroidFastRenderView(AndroidGame game, Bitmap framebuffer) {
		super(game);
		this.game = game;
		this.framebuffer = framebuffer;
		this.holder = getHolder();

	}

	public void resume() {
		running = true;
		renderThread = new Thread(this);
		renderThread.start();

	}

	public void run() {
		Rect dstRect = new Rect();
		/*
		long startTime = System.nanoTime();
		while (running) {
			if (!holder.getSurface().isValid())
				continue;

			float deltaTime = (System.nanoTime() - startTime) / 10000000.000f;
			startTime = System.nanoTime();

			if (deltaTime > 3.15) {
				deltaTime = (float) 3.15;
			}

			game.getCurrentScreen().update(deltaTime);
			game.getCurrentScreen().paint(deltaTime);

			Canvas canvas = holder.lockCanvas();
			canvas.getClipBounds(dstRect);
			canvas.drawBitmap(framebuffer, null, dstRect, null);
			holder.unlockCanvasAndPost(canvas);

		}*/
		
		long beginTime;     // the time when the cycle begun
		    long deltaTime;      // the time it took for the cycle to execute
		    int sleepTime;      // ms to sleep (<0 if we're behind)
		    int framesSkipped;  // number of frames being skipped 
		 
		    sleepTime = 0;

		    while (running) {
		    	Canvas canvas = null;
		        // try locking the canvas for exclusive pixel editing
		        // in the surface
		        try {
		            canvas = holder.lockCanvas();
		            synchronized (holder) {
		                beginTime = System.currentTimeMillis();
		                framesSkipped = 0;  // resetting the frames skipped
		                // update game state 
		                // calculate how long did the cycle take
		                deltaTime = System.currentTimeMillis() - beginTime;

		                // update deltatime?
		                game.getCurrentScreen().update(deltaTime/ 10000000.000f);
		               
		                // render state to the screen
		                // draws the canvas on the panel
		                
		                //?
		                //this.gamePanel.render(canvas);              
		                game.getCurrentScreen().paint(deltaTime/ 10000000.000f);
		                
		                // calculate how long did the cycle take
		                deltaTime = System.currentTimeMillis() - beginTime;
		                // calculate sleep time
		                sleepTime = (int)(FRAME_PERIOD - deltaTime);
		                 
		                if (sleepTime > 0) {
		                    // if sleepTime > 0 we're OK
		                    try {
		                        // send the thread to sleep for a short period
		                        // very useful for battery saving
		                        Thread.sleep(sleepTime);    
		                    } catch (InterruptedException e) {}
		                }
		                 
		                while (sleepTime < 0 && framesSkipped < MAX_FRAME_SKIPS) {
		                    // we need to catch up
		                    // update without rendering
			                game.getCurrentScreen().update(deltaTime/ 10000000.000f);
		                    // add frame period to check if in next frame
		                    sleepTime += FRAME_PERIOD;  
		                    framesSkipped++;
		                }
		            }
		        } finally {
		            // in case of an exception the surface is not left in 
		            // an inconsistent state
		            if (canvas != null) {
		            	holder.unlockCanvasAndPost(canvas);
		            }
		        }   // end finally
		    }

	}

	public void pause() {
		running = false;
		while (true) {
			try {
				renderThread.join();
				break;
			} catch (InterruptedException e) {
				// retry
			}

		}
	}

}