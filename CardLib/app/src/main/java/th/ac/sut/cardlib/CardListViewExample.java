package th.ac.sut.cardlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.view.CardListView;
import th.ac.sut.cardlib.CardView.CardViewCustom;


public class CardListViewExample extends AppCompatActivity {

    CardListView cardListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list_view);

        infixView();

        ArrayList<Card> cards = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Card card = new CardViewCustom(this);
            CardHeader cardHeader = new CardHeader(this);
            cardHeader.setTitle("This is header #" + i);

            card.addCardHeader(cardHeader);
            cards.add(card);
        }

        CardArrayAdapter cardArrayAdapter = new CardArrayAdapter(this, cards);
        if (cardListView!=null){
            cardListView.setAdapter(cardArrayAdapter);
        }

    }

    private void infixView() {
        cardListView = (CardListView) findViewById(R.id.card_list_view);
    }
}
