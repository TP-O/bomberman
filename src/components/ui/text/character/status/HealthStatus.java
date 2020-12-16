package components.ui.text.character.status;

import components.ui.text.Text;
import core.Handler;

public class HealthStatus extends Text
{
    public HealthStatus(Handler handler, int column, int row, int left, int right, int top, int bottom)
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
        width = 12;
        height = 12;
        value = "Unknown";
    }
}
