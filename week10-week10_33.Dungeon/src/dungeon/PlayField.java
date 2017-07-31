package dungeon;

public class PlayField {

    private int lenght;
    private int height;
    private char[][] playField;

    public PlayField(int lenght, int height) {
        this.lenght = lenght;
        this.height = height;
        this.playField = new char[lenght][height];
    }

    public void SetPoint(int lenght, int height, char c) {
        this.playField[lenght][height] = c;
    }

    public void PrintPlayField() {
        for (int h = 0; h < this.height; h++) {
            for (int l = 0; l < this.lenght; l++) {
                System.out.print(this.playField[l][h]);
            }
            System.out.println("");
        }
    }

    public void CreateEmptyPlayField() {
        for (int h = 0; h < this.height; h++) {
            for (int l = 0; l < this.lenght; l++) {
                this.playField[h][l] = '.';
            }
        }
    }
    
    public void Clear(){
        this.playField = new char[lenght][height];
    }
}
