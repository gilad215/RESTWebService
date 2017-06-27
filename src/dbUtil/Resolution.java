package dbUtil;
import javax.persistence.*;

@Entity(name="Solutions")
public class Resolution {


    @Id
    @Column(name="LevelName",nullable=false)
    private String LevelName;

    @Column(name = "Solution")
    private String solution;

    public Resolution() {
    }

    public Resolution(String LevelName, String solution)
    {
        this.LevelName=LevelName;
        this.solution=solution;
    }


    @Override
    public String toString()
    {
        String str="ID:"+this.LevelName+" Resolution:"+solution;
        return str;
    }
    public String getLevelName() {
        return LevelName;
    }

    public void setLevelName(String levelName) {
        LevelName = levelName;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

}
