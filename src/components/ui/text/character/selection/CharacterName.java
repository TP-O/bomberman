package components.ui.text.character.selection;

import components.ui.text.Text;

public class CharacterName extends Text {

    public CharacterName(int column, int row, int left, int right, int top, int bottom) {
        super(column, row, left, right, top, bottom);
    }

    @Override
    public void onHover() {
        //
    }

    @Override
    public void onClick() {
        //
    }

    @Override
    public void onWaiting() {
        //
    }

    @Override
    protected void setElementParameters() {
        width = 32;
        height = 32;
        value = "Goku";
    }
}
