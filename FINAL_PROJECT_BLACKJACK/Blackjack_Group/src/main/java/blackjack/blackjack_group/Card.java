package blackjack.blackjack_group;
/**
card class - basically defines what a card is and allows other classes to use individual cards when needed

@author Jacob Metcalfe
modified by Justin Kadyrov
@version 1.0
@since 2023-04-02
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Card {
    /*
    enumeration for different suit's of cards
     */
    enum Suit {
        SPADES,
        HEARTS,
        DIAMONDS,
        CLUBS
    }
    /*
    enumeration for values of cards
     */
    enum Value {
    NULL(0),
    ACE(11),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10);

    private int value;

    //constructor for value
    Value(int value) {
        this.value = value;
    }

    //allows other classes to get values
    public int getValue() {
        return value;
    }
}

    private Suit suit;
    private Value value;
    private Random rand = new Random();

    // card constructor with random values for suits and card values (all possible from enums)
    public Card(){
        this.setSuit(Suit.values()[rand.nextInt(4)]);
        this.setValue(Value.values()[rand.nextInt(13) + 1]);
    }
    // card constructor that sets suit and sets value
    public Card(Suit suit, Value value){
        this.suit = suit;
        this.value = value;
    }

    // suit setter, value setter, value getter, suit getter, and toString
    public void setSuit(Suit suit){
        this.suit = suit;
    }
    public void setValue(Value value){
        this.value = value;
    }
    public Value getValue(){
        return value;
    }
    public Suit getSuit(){
        return suit;
    }
    public String toString(){
        return value + " of " + suit;
    }
    public int getCardValue() {
    return value.getValue();
}


/**
this method defines what image to appear based on text
if the value is jack - changes value to jack etc
 */
public String getImagePath() {
    String valueStr;
    switch (value) {
        case JACK:
            valueStr = "jack";
            break;
        case QUEEN:
            valueStr = "queen";
            break;
        case KING:
            valueStr = "king";
            break;
        case ACE:
            valueStr = "ace";
            break;
        default:
            valueStr = Integer.toString(value.ordinal());
    }
    //returns the path of the card images and adds the value to it, changes it to always work for every file by making lowercase
    return "FINAL_PROJECT_BLACKJACK\\Blackjack_Group\\src\\main\\cards\\" + valueStr + "_of_" + suit.toString().toLowerCase() + ".png";
}


/**
gathers card image files using fileInputStream,
if file doesn't exist, throws IllegalArgumentException,
otherwise - card image is stored in the object
 */
public ImageView getCardImageView() {
    String imagePath = getImagePath();
    File imageFile = new File(imagePath);
    if (!imageFile.exists()) {
        throw new IllegalArgumentException("Cannot find card image: " + imagePath);
    }
    try {
        FileInputStream inputStream = new FileInputStream(imageFile);
        Image image = new Image(inputStream);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(100);
        imageView.setFitHeight(150);
        return imageView;
    } catch (FileNotFoundException ex) {
        throw new IllegalArgumentException("Cannot find card image: " + imagePath, ex);
    }
    
}

}
