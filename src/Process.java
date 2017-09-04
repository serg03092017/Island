class Process {
    int x[];
    int y[];
    int z[];
    String condition[];
    int x_min;
    int y_min;
    int z_min;
    int x_max;
    int y_max;
    int z_max;
    int volume=0;

    public Process(int[] x1, int[] y1, int[] z1, String[] condition1, int i, int min_width, int min_dept, int min_height, int max_width, int max_dept, int max_height) {
        x_min=min_width;
        y_min=min_dept;
        z_min=min_height;
        x_max=max_width-1;
        y_max=max_dept-1;
        z_max=max_height;
        for (int k1 = 0; k1 < i; k1++) {
            this.x = x1;
            this.y = y1;
            this.z = z1;
            this.condition = condition1;
            all_wall(x[k1], y[k1], z[k1],condition [k1],k1);

        }

        volume=water_count_final();
    }

    public void return_values(int[] x, int[] y, int[] z, String[] condition, int i) {
        for (int k1=0; k1 < i;k1++) {
        System.out.println("z="+z[k1]+" y="+y[k1]+" x="+x[k1]+" condition="+ condition[k1]);
        }
    }

    void all_wall (int a, int b, int c, String d, int i) {
        a = this.x[i];
        b = this.y[i];
        c = this.z[i];
        d = this.condition[i];
        //System.out.println("a=" + a + " b=" + b + " c=" + c + " i=" + i + " cond=" + d);

        boolean result = true;
        if (condition[get_index(a, b, c)] == "wall") result = false;
        int a_go;
        int b_go;
        int c_go;

        if (result) {
            a_go = a;
            if (a_go <= x_min) result = false;
            do {
                a_go = a_go - 1;
                if (a_go < x_min) {
                    a_go = a_go + 1;
                    result = false;
                    break;
                }
                if (condition[get_index(a_go, b, c)] == "wall") {
                    break;
                }
            }
            while (result == true);
        }

        if (result) {
            a_go = a;
            if (a_go >= x_max) result = false;
            do {
                a_go = a_go + 1;
                if (a_go > x_max) {
                    a_go = a_go - 1;
                    result = false;
                    break;
                }
                if (condition[get_index(a_go, b, c)] == "wall") {
                    break;
                }
            }
            while (result == true);
            }

        if (result) {
            b_go = b;
            if (b_go <= y_min) result = false;
            do {
                b_go = b_go - 1;
                if (b_go < y_min) {
                    b_go = b_go + 1;
                    result = false;
                    break;
                }
                if (condition[get_index(a, b_go, c)] == "wall") {
                    break;
                }
            }
            while (result == true);
        }

        if (result) {
            b_go = b;
            if (b_go >= y_max) result = false;
            do {
                b_go = b_go + 1;
                if (b_go > y_max) {
                    b_go = b_go - 1;
                    result = false;
                    break;
                }
                if (condition[get_index(a, b_go, c)] == "wall") {
                    break;
                }
            }
            while (result == true);
        }

        if (result) {
            c_go = c;
            if (c_go <= z_min) result = false;
            do {
                c_go = c_go - 1;
                if (c_go < z_min) {
                    c_go = c_go + 1;
                    result = false;
                    break;
                }
                if (condition[get_index(a, b, c_go)] == "wall") {
                    break;
                }
            }
            while (result == true);
        }
        if (result){
            condition[get_index(a, b, c)]="water";
        }
        //System.out.println(result);
    }

    int get_index(int width,int dept, int height)
    {
        return (dept*(x_max+1)*z_max+width*z_max+height-1);
    }

    int return_value(int volume_result)
    {
        return volume_result;
    }

    int water_count_final(){
        int control_sum_before;
        int control_sum_after;

        do {
            control_sum_before=0;
            control_sum_after=0;
            int count_water = 0;
            for (int k1 = 0; k1 < ((x_max + 1) * (y_max + 1) * z_max); k1++) {
                //System.out.println(condition[k1]);
                if (condition[k1] == "water")  count_water++;
            }

// определили размер массива

            int water_mass[] = new int[count_water];
            int count_mass_elements = 0;
            for (int k1 = 0; k1 < ((x_max + 1) * (y_max + 1) * z_max); k1++) {
                if (condition[k1] == "water")
                {
                    water_mass[count_mass_elements] = k1;
                    count_mass_elements++;
                }
            }
            control_sum_before=water_mass.length;

// записали в массив k  такие где "water"
            for (int i=0;i<water_mass.length;i++) {
                if (one_step(water_mass[i]) == true)
                {
                    control_sum_after++;
                }
                else {
                    condition[water_mass[i]]="air";
                }

            }
            //System.out.println();
        }
        while (control_sum_before!=control_sum_after);
        return control_sum_after;
    }

    boolean one_step(int k){
        boolean result=true;
        int a=return_a(k);
        int b=return_b(k);
        int c=return_c(k);

        if (condition[get_index(a + 1, b, c)] == "air") {result = false;}
        if (condition[get_index(a - 1, b, c)] == "air") {result = false;}
        if (condition[get_index(a, b+1, c)] == "air") {result = false;}
        if (condition[get_index(a, b-1, c)] == "air") {result = false;}
        return result;
    }

    int return_a(int k){
        return ( (k-((x_max+1)*z_max*(k/((x_max+1)*(z_max)))))/z_max );
        //false
    }

    int return_b(int k){
        return ( k/((x_max+1)*(z_max)) );
    }

    int return_c(int k){
        return ((k)%z_max+1);
    }

}
