package th.ac.sut.cardlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.view.CardView;
import th.ac.sut.cardlib.CardView.CardViewCustom;

public class CustomCardView extends AppCompatActivity {

    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_card_view);
        infixView();

        Card card = new CardViewCustom(this);
        CardHeader cardHeader = new CardHeader(this);
        cardHeader.setTitle("This is header");

        card.setTitle("This is Title of Card");
        card.addCardHeader(cardHeader);
        cardView.setCard(card);

    }

    private void infixView() {
        cardView = (CardView) findViewById(R.id.card);
    }
}
