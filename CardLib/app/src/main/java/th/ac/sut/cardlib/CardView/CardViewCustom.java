package th.ac.sut.cardlib.CardView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import it.gmariotti.cardslib.library.internal.Card;
import th.ac.sut.cardlib.R;

/**
 * Created by Developer on 28/7/2559.
 */
public class CardViewCustom extends Card {

    public CardViewCustom(Context context) {
        super(context, R.layout.list_item_card);
    }

    public CardViewCustom(Context context, int innerLayout) {
        super(context, innerLayout);
    }

    @Override
    public void setupInnerViewElements(ViewGroup parent, View view) {
        super.setupInnerViewElements(parent, view);

        TextView title = (TextView) view.findViewById(R.id.title);
        title.setText("Hello World");
    }
}
