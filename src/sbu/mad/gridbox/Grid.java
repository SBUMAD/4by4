package sbu.mad.gridbox;


public class Grid {
	public int[][] grid;
	public Grid(int n, int m){
		grid = new int[n][m];
		for(int i=0;i<4;i++)
		{
			grid[0][i]=4;
		}
	}
	
	public void moveUp(){
		for(int i=1;i<grid.length;i++)
		{
			for(int j=0;j<grid[i].length;j++)
			{
				for(int k=i;k>0;k--)
				{
					if(grid[k-1][j] == 0)
					{
						grid[k-1][j] = grid[k][j];
						grid[k][j] = 0;
					}else if(grid[k-1][j] == grid[k][j])
					{
						grid[k-1][j] += grid[k][j];
						grid[k][j] = 0;
						k=-2;
					}else{
						k=-2;
					}
				}
			}
		}
		if(!checkIfFull()){
			addRandom4();
		}else{
			gameOver();
		}
	}
	
	public void moveDown(){

		for(int i=grid.length-2;i > -1;i--)
		{
			for(int j=0;j<grid[i].length;j++)
			{
				for(int k=i;k<grid.length-1;k++)
				{
					if(grid[k+1][j] == 0)
					{
						grid[k+1][j] = grid[k][j];
						grid[k][j] = 0;
					}else if(grid[k+1][j] == grid[k][j])
					{
						grid[k+1][j] += grid[k][j];
						grid[k][j] = 0;
						k=grid.length;
					}else{
						k=grid.length;
					}
				}
			}
		}
		if(!checkIfFull()){
			addRandom4();
		}else{
			gameOver();
		}
	}
	
	public void moveLeft(){
		
		for(int j=0;j<grid[0].length;j++)
		{
			for(int i=0;i<grid.length;i++)
			{
				for(int k=j;k>0;k--)
				{
					if(grid[i][k-1] == 0)
					{
						grid[i][k-1] = grid[i][k];
						grid[i][k] = 0;
					}else if(grid[i][k-1] == grid[i][k]){
						grid[i][k-1] += grid[i][k];
						grid[i][k] = 0;
						k=-2;
					}else{
						k=-1;
					}
				}
			}
		}
		
		if(!checkIfFull()){
			addRandom4();
		}else{
			gameOver();
		}
	}
	
	public void moveRight(){
		for(int j=grid[0].length-1;j>=0;j--)
		{
			for(int i=0;i<grid.length;i++)
			{
				for(int k=j;k<grid[0].length-1;k++)
				{
					if(grid[i][k+1] == 0)
					{
						grid[i][k+1] = grid[i][k];
						grid[i][k] = 0;
					}else if(grid[i][k+1] == grid[i][k]){
						grid[i][k+1] += grid[i][k];
						grid[i][k] = 0;
						k=6;
					}else{
						k=6;
					}
				}
			}
		}
		
		if(!checkIfFull()){
			addRandom4();
		}else{
			gameOver();
		}
	}
	public void gameOver(){
		System.out.println("Game Over");
		grid = new int[grid.length][grid[0].length];
		printGrid();
	}
	
	public boolean checkIfFull(){
		boolean flag = true;
		for(int i=0;i<grid.length;i++)
		{
			for(int j=0;j<grid[i].length;j++)
			{
				if(grid[i][j] == 0)
				{	flag = false;
					return flag;
				}
			}
		}
		return flag;
	}
	public void addRandom4(){
		boolean flag = true;
		while(flag){
			int x = (int)(Math.random() * 4);
			int y = (int)(Math.random() * 4);
			if(grid[x][y] == 0)
			{
				grid[x][y] = 4;
				flag = false;
			}
		}
	}
	
	public String printGrid(){
		String result = "";
		for(int i=0;i<grid.length;i++)
		{
			for(int j=0;j<grid[0].length;j++)
			{
				result += grid[i][j]+"\t";
			}
			result += "\n";
		}
		return result;
	}
}
