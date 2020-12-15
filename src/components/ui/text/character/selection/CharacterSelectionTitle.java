package components.ui.text.character.selection;

import components.ui.text.Text;
import core.Handler;

public class CharacterSelectionTitle extends Text
{
    public CharacterSelectionTitle(Handler handler, int column, int row, int left, int right, int top, int bottom)
    {
        super(handler, column, row, left, right, top, bottom);
    }

    @Override
    public void onHover()
    {
        //
    }

    @Override
    public void onClick()
    {
        //
    }

    @Override
    public void onWaiting()
    {
        //
    }

    @Override
    protected void loadInfo()
    {
        width = 32;
        height = 32;
        value = "Select";
    }    
}
