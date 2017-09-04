class Create_island {

    int x,y,z;
    String condition;

    public Create_island (int height, int depth, int width, int max_height, int k) {
        this.z=k;
        this.x=width;
        this.y=depth;
        if (k<=height) {this.condition="wall";}
        else
        {this.condition="air";}
    }



}
