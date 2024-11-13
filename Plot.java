
public class Plot {

	private int x;
	private int y;
	private int width;
	private int depth;
	
	public Plot() {
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	
	public Plot(Plot otherPlot) {
		x = otherPlot.x;
		y = otherPlot.y;
		width = otherPlot.width;
		depth = otherPlot.depth;
	}
	
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
		
	}
	
	public boolean overlaps(Plot plot) {
		boolean horizontalOverlap = (this.x + this.width) <= plot.x || plot.x + plot.width <= this.x;
		boolean verticalOverlap = (this.y + this.depth) <= plot.y || plot.y + plot.depth <= this.y;
		
		if (horizontalOverlap || verticalOverlap) {
			return false;
		}
		return true;
	}
	
	public boolean encompasses(Plot plot) {
		
		boolean encompassesleft = this.x <= plot.x;
		boolean encompassesright = (this.x + this.width) >= (plot.x + plot.width);
		boolean encompasseswidth = this.y <= plot.y;
		boolean encompassesDepth = (this.y + this.depth) >= (plot.y + plot.depth);
		
		
		if (encompassesleft && encompassesright && encompasseswidth && encompassesDepth) {
			return true;
		}
		return false;
	}
	
	
	
	// X
	public void setX(int x){
		this.x = x;
	}
	public int getX(){
		return x;
	}
	
	// Y
	public void setY(int y){
		this.y = y;
	}
	public int getY(){
		return y;
	}
	
	// Width
	public void setWidth(int width){
		this.width = width;
	}
	public int getWidth(){
		return width;
	}
	
	// Depth
	public void setDepth(int depth){
		this.depth = depth;
	}
	public int getDepth(){
		return depth;
	}


	public String toString() {
		String string;
		
		string =  x + "," + y + "," + width + "," + depth;
		
		return string;
	}

}
