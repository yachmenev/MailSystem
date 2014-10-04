package view;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eugene on 03.10.14.
 */
public class Letter {

    private String from = " ";
    private String topic = " ";
    private static List<String> listLettersFrome = new ArrayList<String>();
    private static List<String> listLettersTopic = new ArrayList<String>();


    public Letter(String from, String topic){
        this.from = from;
        this.topic = topic;
        listLettersFrome.add(from);
        listLettersTopic.add(topic);

    }

    public ArrayList getFrome(){

    return null;
    }
}
