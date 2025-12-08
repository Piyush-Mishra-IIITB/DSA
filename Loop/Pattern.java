public class Pattern{
     public static void Square_hollow(int n){
      //"Square hollow pattern"
       for(int i=0;i<=n;i++){
        for(int j=0;j<=n;j++){
            if(i==0||i==n||j==0||j==n){
                System.out.print("*");
            }else{
                System.out.print(" ");
            }
        }
        System.out.println();
       }
     }
    

     public static void traingular(int n){
        //traingular pattern
        int p=1;
        for(int i=0;i<=n;i++){
            for(int j=1;j<n-i;j++){
                System.out.print(" ");
            }
            for(int j=0;j<=(i);j++){
                System.out.print(p + " ");
            }
            p++;
            System.out.println();
        }

     
     }
     public static void increasing_pyramid(int n){
             for(int i=0;i<=n;i++){
                for(int j=0;j<=i;j++){
                    System.out.print("*");
                }
                System.out.println();
             }


     }
     public static void reverse_pyramid(int n){

        for(int i=0;i<=n;i++){
            for(int j=0;j<=n-i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
     }
     public static void zero_one(int n){
        for (int i=0;i<=n;i++){
            for(int j=0;j<=i;j++){
                if((i+j)%2==0){
                    System.out.print("1");
                }else{
                    System.out.print("0");
                }
            }
            System.out.println();
        }
     }
   public static void palindromic_triangular(int n) {

    for(int i = 1; i <= n; i++) {

        // leading spaces
        for(int j = 1; j <= n - i; j++) {
            System.out.print(" ");
        }

        // increasing numbers i to 1
        for(int j = i; j >1; j--) {
            System.out.print(j);
        }

        // decreasing numbers i-1 to 1
        for(int j = 1; j<=i; j++) {
            System.out.print(j);
        }

        System.out.println();
    }
}
  public static void rhombus_pattern(int n){
    for(int i=1;i<=n;i++){
        for(int j=0;j<=i;j++){
            System.out.print(" ");
        }
        for(int j=1;j<=4;j++){
            System.out.print("*");
        }
        System.out.println();
    }
  }
 public static void diamond_pattern(int n){

    for(int i=1;i<=n;i++){
        for(int j=1;j<=n-i;j++){
            System.out.print(" ");
        }
        for(int j=1;j<=(2*i)-1;j++){
            System.out.print("*");
        }
        System.out.println();
    }
    for(int i=n;i>=1;i--){
        for(int j=1;j<=n-i;j++){
            System.out.print(" ");
        }
        for(int j=1;j<=(2*i)-1;j++){
            System.out.print("*");
        }
        System.out.println();
    }
 }
 public static void butterfly_pattern(int n)
{
for(int i=0;i<=n;i++){
    for(int j=0;j<=i;j++){
        System.out.print("*");
    }
    for(int j=0;j<n-i;j++){
        System.out.print(" ");
    }
    for(int j=0;j<n-i;j++){
        System.out.print(" ");
    }for(int j=0;j<=i;j++){
        System.out.print("*");
    }
    System.out.println();
}
for(int i=1;i<=n;i++){
    for(int j=0;j<=n-i;j++){
        System.out.print("*");
    }
    for(int j=0;j<i;j++){
        System.out.print(" ");
    }
    for(int j=0;j<i;j++){
        System.out.print(" ");
    }
    for(int j=0;j<=n-i;j++){
        System.out.print("*");
    }

    System.out.println();
}
}
public static void square(int n){
    for(int i=0;i<=n;i++){
        for(int j=0;j<=n;j++){
            System.out.print("*");
        }
        System.out.println();
    }
}
public static void k_pattern(int n){

 for(int i=0;i<n;i++){
    for(int j=0;j<n-i;j++){
        System.out.print("*");
    }
    System.out.println();
 }
 for(int i=1;i<=n;i++){
    for(int j=0;j<=i;j++){
        System.out.print("*");
    }
    System.out.println();
 }

}
public static void mirror_traingle(int n){
    for(int i=0;i<n;i++){
        for(int j=0;j<i;j++){
            System.out.print(" ");
        }
        for(int j=0;j<n-i;j++){
            System.out.print("* ");
        }
        System.out.println();
    }
    for(int i=n-2;i>=0;i--){
        for(int j=0;j<i;j++){
            System.out.print(" ");
        }
        for(int j=0;j<n-i;j++){
            System.out.print("* ");
        }
        System.out.println();
    }
}
public static void diamond_hollow(int n){
       for(int i=1;i<=n;i++){
        for(int j=1;j<=n-i;j++){
            System.out.print(" ");
        }
        for(int j=1;j<=(2*i)-1;j++){
            if(j==1||j==(2*i)-1){
            System.out.print("*");}
            else{
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    for(int i=n;i>=1;i--){
        for(int j=1;j<=n-i;j++){
            System.out.print(" ");
        }
        for(int j=1;j<=(2*i)-1;j++){
            if(j==1||j==(2*i)-1){
            System.out.print("*");}
        else{
                System.out.print(" ");
            }}
        System.out.println();
    }
 }


    public static void main(String args[]){
      Square_hollow(5);
      traingular(5);
      increasing_pyramid(5);
      reverse_pyramid(5);
      zero_one(5);
      palindromic_triangular(5);
      rhombus_pattern(5);
      diamond_pattern(5);
      butterfly_pattern(5);
      square(5);
      k_pattern(5);
      mirror_traingle(5);
      diamond_hollow(5);
    }
}