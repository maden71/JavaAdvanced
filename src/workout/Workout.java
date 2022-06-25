package workout;
import java.util.ArrayList;
import java.util.List;

public class Workout {
    private String type;
    private int exerciseCount;
    List<Exercise> exercises = new ArrayList<>();

    public Workout(String type,int exerciseCount){
        this.type = type;
        this.exerciseCount = exerciseCount;
    }

    public void addExercise(Exercise exercise){
        if(this.exercises.size() < exerciseCount) {
            this.exercises.add(exercise);
        }
    }
    public boolean removeExercise(String name, String muscle){
        for (Exercise exercise : exercises) {
            if(exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                exercises.remove(exercise);
                return true;
            }
        }
        return false;
    }
    public Exercise getExercise(String name, String muscle){
        for (Exercise exercise : exercises) {
            if(exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                return exercise;
            }
        }
        return null;
    }
    public Exercise getMostBurnedCaloriesExercise(){
        if(exercises.isEmpty()) {
            return null;
        }
        int mostCalories = this.exercises.get(0).getBurnedCalories();
        Exercise mostBurnedEx = this.exercises.get(0);
        for (Exercise exercise : exercises) {
            if(exercise.getBurnedCalories() > mostCalories) {
                mostCalories = exercise.getBurnedCalories();
                mostBurnedEx = exercise;
            }
        }
        return mostBurnedEx;
    }
    public int getExerciseCount(){
        return this.exercises.size();
    }

    public String getStatistics(){
        StringBuilder result = new StringBuilder();
        result.append(String.format("Workout type: %s",this.type));
        this.exercises.forEach(ex -> result.append(System.lineSeparator()).append(ex));
        return result.toString();
    }

}
