package twofishes.pipedream.gui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import twofishes.pipedream.gui.controller.TileController;
import twofishes.pipedream.pipe.AbsPipe;
import twofishes.pipedream.pipe.CrossPipe;
import twofishes.pipedream.pipe.Entrance;
import twofishes.pipedream.pipe.HorizontalPipe;
import twofishes.pipedream.pipe.NorthEastElbowPipe;
import twofishes.pipedream.pipe.NorthWestElbowPipe;
import twofishes.pipedream.pipe.SouthEastElbowPipe;
import twofishes.pipedream.pipe.SouthWestElbowPipe;
import twofishes.pipedream.pipe.StarterPipeEast;
import twofishes.pipedream.pipe.StarterPipeNorth;
import twofishes.pipedream.pipe.StarterPipeSouth;
import twofishes.pipedream.pipe.StarterPipeWest;
import twofishes.pipedream.pipe.VerticalPipe;
import twofishes.pipedream.tile.Tile;


public class TileView extends AbsView implements ITileView, MouseListener {
	private Tile tile;
	
	private Dimension dim ;
	
	public TileView() {
		addMouseListener(this);
	}
	
	public void setTile(Tile tile) {
		this.tile = tile;
		dim = new Dimension(50, 50) ;
		this.setPreferredSize(dim) ;
		this.setSize(50, 50);
	}
	
	public void paintComponent(Graphics g)
    {
       super.paintComponent(g);

       
       
       Graphics2D g2 = (Graphics2D)g;

       AbsPipe pipe = tile.getCurrentPipe() ;       
       
       g2.setColor(Color.BLACK);

       g2.drawRect(0, 0, 49, 49);
       //g2.drawLine(50, 0, 50, 50);

       paintPipe(g2, pipe) ;
       
       //draw red rectangle
       g2.setColor(Color.RED);
       //g2.fillRect(0, 0, 10, 10);

       //draw border
       g2.setColor(Color.BLUE);
       g2.drawRect(0, 0, 49, 49);
       
       //draw coords
       g2.setColor(Color.RED) ;
       g2.drawString(tile.getX() + "," + tile.getY(), 0, this.getHeight()) ;
       
    }

	public void mouseClicked(MouseEvent arg0) {
		//TODO Don't create new TileController here - Inject singleton instead
		TileController tileController = new TileController();
		tileController.handleClick(this.tile);
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	private void paintPipe(Graphics2D g2, AbsPipe pipe) {
		//TODO use bitmaps
		Image image = getPipeImage(pipe) ;
		g2.drawImage(image, new AffineTransform(1f,0f,0f,1f,0,0), null) ;
	}

	private BufferedImage getPipeImage(AbsPipe pipe) {
		//get appropriate bitmap of appropriate pipe with appropriate fill amount
		//TODO get actual bitmaps...for now just draw something

		BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB) ;
		Graphics2D g = bi.createGraphics() ;

		if(pipe!=null) {
			
			int px = 0 ;
			int py = 0 ;
			
			int pwidth = getWidth() ;
			int pheight = getHeight() ;
			
			int pw = pwidth ;
			int ph = pheight ;
			
			int pl = pw/4 ;
			int pl2 = pl/2 ;
			
			int pw2 = pw/2 ;
			int ph2 = ph/2 ;				
			
			int cx = px+pwidth/2 ; 
			int cy = py+pheight/2 ;
			
			int lx = px ; 
			int ly = py+pheight/2 ;
			
			int rx = px+pwidth ;
			int ry = py+pheight/2 ;
			
			int tx = px+pwidth/2 ;
			int ty = py ;
			
			int bx = px+pwidth/2 ;
			int by = py+pheight ;
			
			int lx1 = lx ; 
			int ly1 = ly+pl2 ;
			int lx2 = lx ; 
			int ly2 = ly-pl2 ;

			int rx1 = rx ;
			int ry1 = ry-pl2 ;
			int rx2 = rx ;
			int ry2 = ry+pl2 ;
			
			int tx1 = tx-pl2 ;
			int ty1 = ty ;
			int tx2 = tx+pl2 ;
			int ty2 = ty ;
			
			int bx1 = bx+pl2 ;
			int by1 = by ;
			int bx2 = bx-pl2 ;
			int by2 = by ;			
			
			Class pipeClz = pipe.getClass() ;

			int sgoo = pipe.getStartGooCount() ;
			int goo = pipe.getGooCount() ; //goes to zero

			boolean unknown = true ;
			float ratio = ((float)(sgoo-goo) / (float)sgoo) ;
			//ratio = 0.5f ;
			if(pipeClz == VerticalPipe.class) {
				paintPipeSegment(g, tx, ty, bx, by, tx1, tx2, ty1, ty2, bx1, bx2, by1, by2) ;
				//which was is the flow?
				Entrance entranceEntered = pipe.getEntranceEntered() ;
				if(entranceEntered!=null) {
					switch(entranceEntered) {
					case NORTH:
						paintGooSegment(g, ratio, tx, ty, bx, by, tx1, tx2, ty1, ty2, bx1, bx2, by1, by2) ; break ;
					case SOUTH:
						paintGooSegment(g, ratio, bx, by, tx, ty, bx1, bx2, by1, by2, tx1, tx2, ty1, ty2) ; break ;
					default:
						g.drawString("wtf", 0, this.getHeight()-40) ;
					}
				}
				unknown=false ;
			}
			if(pipeClz == HorizontalPipe.class) {
				paintPipeSegment(g, lx, ly, rx, ry, lx1, lx2, ly1, ly2, rx1, rx2, ry1, ry2) ;

				Entrance entranceEntered = pipe.getEntranceEntered() ;
				if(entranceEntered!=null) {
					switch(entranceEntered) {
					case EAST:
						paintGooSegment(g, ratio, rx, ry, lx, ly, rx1, rx2, ry1, ry2, lx1, lx2, ly1, ly2) ; break ;
					case WEST:
						paintGooSegment(g, ratio, lx, ly, rx, ry, lx1, lx2, ly1, ly2, rx1, rx2, ry1, ry2) ; break ;
					default:
						g.drawString("wtf", 0, this.getHeight()-40) ;
					}
				}
				
				unknown=false ;
			}
			if(pipeClz == NorthEastElbowPipe.class) {
				paintPipeSegment(g, rx, ry, tx, ty, rx1, rx2, ry1, ry2, tx1, tx2, ty1, ty2) ;

				Entrance entranceEntered = pipe.getEntranceEntered() ;
				if(entranceEntered!=null) {
					switch(entranceEntered) {
					case NORTH:
						paintGooSegment(g, ratio, tx, ty, rx, ry, tx1, tx2, ty1, ty2, rx1, rx2, ry1, ry2) ; break ;
					case EAST:
						paintGooSegment(g, ratio, rx, ry, tx, ty, rx1, rx2, ry1, ry2, tx1, tx2, ty1, ty2) ; break ;
					default:
						g.drawString("wtf", 0, this.getHeight()-40) ;
					}
				}
				
				unknown=false ;
			}
			if(pipeClz == NorthWestElbowPipe.class) {
				paintPipeSegment(g, lx, ly, tx, ty, lx1, lx2, ly1, ly2, tx1, tx2, ty1, ty2) ;

				Entrance entranceEntered = pipe.getEntranceEntered() ;
				if(entranceEntered!=null) {
					switch(entranceEntered) {
					case NORTH: paintGooSegment(g, ratio, tx, ty, lx, ly, tx1, tx2, ty1, ty2, lx1, lx2, ly1, ly2) ; break ;
					case WEST: paintGooSegment(g, ratio, lx, ly, tx, ty, lx1, lx2, ly1, ly2, tx1, tx2, ty1, ty2) ; break ;
					default:
						g.drawString("wtf", 0, this.getHeight()-40) ;
					}
				}
				
				unknown=false ;
			}
			
			if(pipeClz == SouthEastElbowPipe.class) {
				paintPipeSegment(g, rx, ry, bx, by, rx1, rx2, ry1, ry2, bx1, bx2, by1, by2) ;

				Entrance entranceEntered = pipe.getEntranceEntered() ;
				if(entranceEntered!=null) {
					switch(entranceEntered) {
					case SOUTH: paintGooSegment(g, ratio, bx, by, rx, ry, bx1, bx2, by1, by2, rx1, rx2, ry1, ry2) ; break ;
					case EAST: paintGooSegment(g, ratio, rx, ry, bx, by, rx1, rx2, ry1, ry2, bx1, bx2, by1, by2) ; break ;
					default:
						g.drawString("wtf", 0, this.getHeight()-40) ;
					}
				}
				
				unknown=false ;
			}
			if(pipeClz == SouthWestElbowPipe.class) {
				paintPipeSegment(g, lx, ly, bx, by, lx1, lx2, ly1, ly2, bx1, bx2, by1, by2) ;
				
				Entrance entranceEntered = pipe.getEntranceEntered() ;
				if(entranceEntered!=null) {
					switch(entranceEntered) {
					case SOUTH: paintGooSegment(g, ratio, bx, by, lx, ly, bx1, bx2, by1, by2, lx1, lx2, ly1, ly2) ; break ;
					case WEST: paintGooSegment(g, ratio, lx, ly, bx, by, lx1, lx2, ly1, ly2, bx1, bx2, by1, by2) ; break ;
					default:
						g.drawString("wtf", 0, this.getHeight()-40) ;
					}
				}
				
				unknown=false ;
			}
			if(pipeClz == CrossPipe.class) {
				paintPipeSegment(g, tx, ty, bx, by, tx1, tx2, ty1, ty2, bx1, bx2, by1, by2) ;
				paintPipeSegment(g, lx, ly, rx, ry, lx1, lx2, ly1, ly2, rx1, rx2, ry1, ry2) ;
				
				Entrance entranceEntered = pipe.getEntranceEntered() ;
				if(entranceEntered!=null) {
					switch(entranceEntered) {
					case NORTH:
						paintGooSegment(g, ratio, tx, ty, bx, by, tx1, tx2, ty1, ty2, bx1, bx2, by1, by2) ; break ;
					case SOUTH:
						paintGooSegment(g, ratio, bx, by, tx, ty, bx1, bx2, by1, by2, tx1, tx2, ty1, ty2) ; break ;
					case EAST:
						paintGooSegment(g, ratio, rx, ry, lx, ly, rx1, rx2, ry1, ry2, lx1, lx2, ly1, ly2) ; break ;
					case WEST:
						paintGooSegment(g, ratio, lx, ly, rx, ry, lx1, lx2, ly1, ly2, rx1, rx2, ry1, ry2) ; break ;					
					default:
						g.drawString("wtf", 0, this.getHeight()-40) ;
					}
				}
				
				unknown=false ;			
			}

			if(pipeClz == StarterPipeNorth.class) {
				paintPipeSegment(g, tx, ty, bx, by, tx1, tx2, ty1, ty2, bx1, bx2, by1, by2) ;
				
				Entrance entranceEntered = pipe.getEntranceEntered() ;
				if(entranceEntered!=null) {
					switch(entranceEntered) {
					case SOUTH:
						paintGooSegment(g, ratio, bx, by, tx, ty, bx1, bx2, by1, by2, tx1, tx2, ty1, ty2) ; break ;
					default:
						g.drawString("wtf", 0, this.getHeight()-40) ;
					}
				}				
				unknown=false ;
			}
			if(pipeClz == StarterPipeSouth.class) {
				paintPipeSegment(g, tx, ty, bx, by, tx1, tx2, ty1, ty2, bx1, bx2, by1, by2) ;
				
				Entrance entranceEntered = pipe.getEntranceEntered() ;
				if(entranceEntered!=null) {
					switch(entranceEntered) {
					case NORTH:
						paintGooSegment(g, ratio, tx, ty, bx, by, tx1, tx2, ty1, ty2, bx1, bx2, by1, by2) ; break ;
					default:
						g.drawString("wtf", 0, this.getHeight()-40) ;
					}
				}				
				unknown=false ;
			}
			if(pipeClz == StarterPipeEast.class) {
				paintPipeSegment(g, lx, ly, rx, ry, lx1, lx2, ly1, ly2, rx1, rx2, ry1, ry2) ;
				
				Entrance entranceEntered = pipe.getEntranceEntered() ;
				if(entranceEntered!=null) {
					switch(entranceEntered) {
					case WEST:
						paintGooSegment(g, ratio, lx, ly, rx, ry, lx1, lx2, ly1, ly2, rx1, rx2, ry1, ry2) ; break ;
					default:
						g.drawString("wtf", 0, this.getHeight()-40) ;
					}
				}

				unknown=false ;
			}
			if(pipeClz == StarterPipeWest.class) {
				paintPipeSegment(g, lx, ly, rx, ry, lx1, lx2, ly1, ly2, rx1, rx2, ry1, ry2) ;
				
				Entrance entranceEntered = pipe.getEntranceEntered() ;
				if(entranceEntered!=null) {
					switch(entranceEntered) {
					case EAST:
						paintGooSegment(g, ratio, rx, ry, lx, ly, rx1, rx2, ry1, ry2, lx1, lx2, ly1, ly2) ; break ;
					default:
						g.drawString("wtf", 0, this.getHeight()-40) ;
					}
				}

				unknown=false ;
			}

			if(unknown) {
				g.drawString("UNKNOWN", 0, getHeight()-20) ;
			}
		}
		else {
			g.drawString("NULL", 0, getHeight()-20) ;
		}
		
		return bi;
		
		
	}
	
	
	private void paintGooSegment(Graphics g, float ratio, 
			int s1x, int s1y,
			int s2x, int s2y,
			int s1x1, int s1x2, int s1y1, int s1y2,
			int s2x1, int s2x2, int s2y1, int s2y2) {
		
		
		
		s2x1 = (int)(((1-ratio)*s1x2 + ratio*s2x1)) ;
		s2y1 = (int)(((1-ratio)*s1y2 + ratio*s2y1)) ;
		
		s2x2 = (int)(((1-ratio)*s1x1 + ratio*s2x2)) ;
		s2y2 = (int)(((1-ratio)*s1y1 + ratio*s2y2));
		
		//g.fillRect(s1x, s1y, 5, 5) ;
		g.setColor(Color.GREEN) ;
		g.fillPolygon(new int[] {s1x1,s1x2, s2x1, s2x2} , new int[] {s1y1,s1y2,s2y1,s2y2}, 4) ;
		//g.drawLine(s1x, s1y, s2x, s2y) ;
	}	
	
	
	private void paintPipeSegment(Graphics g, 
			int s1x, int s1y,
			int s2x, int s2y,
			int s1x1, int s1x2, int s1y1, int s1y2,
			int s2x1, int s2x2, int s2y1, int s2y2) {
		
		//g.fillRect(s1x, s1y, 5, 5) ;
		g.drawPolygon(new int[] {s1x1,s1x2, s2x1, s2x2} , new int[] {s1y1,s1y2,s2y1,s2y2}, 4) ;
		//g.drawLine(s1x, s1y, s2x, s2y) ;
	}	
}
