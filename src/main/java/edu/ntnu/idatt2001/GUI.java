package edu.ntnu.idatt2001;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class GUI extends Application {

    Styling style = new Styling();


    private Text displayInformationText = new Text();

    private Pane cardWindow = new Pane();

    private HBox gameplayPane = new HBox();



    @Override
    public void start(Stage primaryStage) {
        // Create the start page with a button
        VBox startLayout = new VBox();
        Text title = new Text("Card Game");
        title.setStyle(new Styling().getTitleStyle());

        //title.setStyle(style.getTitleStyle());

        Button startButton = new Button("Start game");
        startButton.setStyle(style.getButtonsStyle());

        startButton.setOnAction(e -> {
            // Open the card game GUI when the button is clicked
            VBox cardGameLayout = createCardGameLayout();
            Scene cardGameScene = new Scene(cardGameLayout, 1000, 700);

            primaryStage.setScene(cardGameScene);
            System.out.println("Start game button pressed");
        });

        startLayout.getChildren().addAll(title, startButton);
        startLayout.setAlignment(Pos.CENTER);
        startLayout.setStyle(style.getBackgroundColor());



        // Create the scene for the start page
        Scene startScene = new Scene(startLayout, 1000, 700);


        primaryStage.setScene(startScene);
        primaryStage.setTitle("Card Game");
        primaryStage.show();
    }

    private VBox createCardGameLayout() {



        // Create the layout for the card game GUI
        VBox layout = new VBox();
        layout.setStyle(style.getBackgroundColor());

        cardWindow.setPrefSize(500, 300);
        cardWindow.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

        cardWindow.setBackground(new Background(new BackgroundFill(
                Color.web("#284B63"),    // Background color
                new CornerRadii(10),    // Corner radii (top-left, top-right, bottom-right, bottom-left)
                Insets.EMPTY)));
        cardWindow.setStyle(style.getCardWindowColor());
        cardWindow.setBorder(new Border(new BorderStroke(Color.web("#534B52"), BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(5))));



        Button dealHand = new Button("Deal hand");
        dealHand.setOnAction(e -> {

            HandOfCards currentHand = new HandOfCards(new DeckOfCards().drawHand(5));
            System.out.println("Deal hand button pressed");

            int spacing = 20; // Set the desired spacing between the images
            int startX = 45;

            for(int i = 0; i < 5; i++) {
                String imagePath = "file:src/main/resources/52cards/"+currentHand.getCard(i).getAsString()+".png";
                Image image = new Image(imagePath);
                ImageView imageView = new ImageView(image);
                imageView.setX(1000 + (i-1)*30);
                imageView.setY(130);
                imageView.setFitWidth(66);
                imageView.setFitHeight(100);
                imageView.setX(startX + i * (imageView.getFitWidth() + spacing));

                cardWindow.getChildren().add(imageView);
            }

            displayInformationText.setVisible(false);
            displayInformationText.setText(currentHand.toSmallString());
            displayInformationText.setStyle(style.getFontStyle());


        });
        dealHand.setStyle(style.getButtonsStyle());


        Button checkHand = new Button("Check hand");
        checkHand.setOnAction(e -> {
            System.out.println("Check hand button pressed");

            displayInformationText.setVisible(true);



        });
        checkHand.setStyle(style.getButtonsStyle());


        HBox statistics = new HBox();

        Text constantText = new Text("Sum of cards: "+"\n" +"Same color: "+"\n"+ "Flush: ");
        constantText.setStyle(style.getFontStyle());
        constantText.setTextAlignment(TextAlignment.RIGHT);




        statistics.setAlignment(Pos.CENTER);
        statistics.getChildren().addAll(constantText, displayInformationText);

        gameplayPane.setStyle(style.getBackgroundColor());

        gameplayPane.getChildren().addAll(checkHand, dealHand);
        gameplayPane.setAlignment(Pos.CENTER);
        gameplayPane.setSpacing(50);
        //CARD PICTURES PART

        layout.getChildren().addAll(cardWindow, gameplayPane, statistics);
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(50);

        return layout;
    }


}
