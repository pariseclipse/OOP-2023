package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{
	// Player and bug objects
	Player player;
	Bug bug;

	// Attributes

	public void settings()
	{
		// size(500, 500);
		fullScreen();
	}

	public void setup()
	{
		colorMode(HSB);
		background(0);
		this.player = new Player();
		this.bug = new Bug();

		smooth();
	}

	public void draw()
	{
		background(0);

		// drawplayer(playerX, playerY, playerWidth);

		if (frameCount % 60 == 0)
		{
			this.bug.move();
		}

		if (this.bug.getY() > height)
		{
			this.bug.resetBug();
		}

		this.player.draw();
		this.bug.draw();

	}

	public void keyPressed()
	{
		if (keyCode == LEFT)
		{
			System.out.println("Left");
			player.moveLeft();
		}
		if (keyCode == RIGHT)
		{
			System.out.println("Right");
			player.moveRight();
		}
		if (key == ' ')
		{
			System.out.println("Space");
			player.shoot(bug);
		}
	}


	class GameEntity
	{
		// Attributes
		private float x;
		private float y;
		private float w;
		private float h;

		// Constructor
		public GameEntity(int x, int y, int w, int h)
		{
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
		}

		public float getX() { return this.x; }

		public float getY() { return this.y; }

		public float getW() { return this.w; }

		public float getH() { return this.h; }

		public void moveX(float dx)
		{
			if (this.x + dx < 0)
			{
				this.x = 0;
				return;
			}
			if (this.x + dx > width)
			{
				this.x = width;
				return;
			}
			this.x += dx;
		}

		public void moveY(float dy)
		{
			if (this.y + dy < 0)
			{
				this.y = 0;
				return;
			}
			if (this.y + dy > height)
			{
				this.y = height;
				return;
			}
			this.y += dy;
		}
	}

	class Player extends GameEntity
	{
		float speed = 10;
		public Player()
		{
			super(width/2, height - 100, 100, 50);
		}

		public void resetPlayer()
		{
			super.x = width / 2;
			super.y = height - 100;
		}

		public void moveLeft()
		{
			super.moveX(-speed);
		}
		public void moveRight()
		{
			super.moveX(speed);
		}

		public void shoot(Bug bug)
		{
			stroke(255);
			line(super.x, super.y, super.x, 0);
			if (bug.isHit(super.x))
			{
				bug.resetBug();
			}
		}

		public void draw()
		{
			fill(255);
			stroke(255);
			strokeWeight(2);

			// Origin of graphics is top left
			float originX = super.x - super.w/2;
			float originY = super.y - super.h/2;

			line(originX, originY, originX + super.w, originY);
		}
	}

	class Bug extends GameEntity
	{
		float speed = 10;

		public Bug()
		{
			super(width/2, 0, 100, 50);
		}
		public void resetBug()
		{
			super.x = random(0, width);
			super.y = 0;
		}

		public void move()
		{
			super.moveX(random(-100, 100));
			super.moveY(100);
		}

		public boolean isHit(float x)
		{
			return x > super.x - super.w/2 && x < super.x + super.w/2;
		}

		public void draw()
		{
			fill(255);
			stroke(255);
			strokeWeight(2);

			// Origin of graphics is top left
			float originX = super.x - super.w/2;
			float originY = super.y - super.h/2;

			// triangle(super.x - super.w/2, super.y - super.h/2, super.x + super.w/2, super.y - super.h/2, super.x, super.y + super.h/2);
			triangle(originX, originY, originX + super.w, originY, originX + super.w/2, originY + super.h);

		}
	}
}