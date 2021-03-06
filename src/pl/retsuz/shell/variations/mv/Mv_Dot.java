package pl.retsuz.shell.variations.mv;

import pl.retsuz.filesystem.Composite;
import pl.retsuz.filesystem.IComposite;
import pl.retsuz.shell.gen.ICommand;
import pl.retsuz.shell.variations.gen.CommandVariation;
import pl.retsuz.shell.variations.gen.ICommandVariation;

public class Mv_Dot extends CommandVariation {
    public Mv_Dot(ICommandVariation next, ICommand parent) {
        super(next, parent, "([a-zA-Z0-9.l\\/_]*\\s\\.)");
    }

    @Override
    public void make(String params) {
        Composite c = (Composite) (this.getParent().getContext().getCurrent());
        try {
            String[] paths = params.split(" ");
            IComposite element = c.findElementByPath(paths[0]);
            IComposite src = element.getParent();
            Composite.moveElement(src, c, element);
            System.out.println("Przeniesiono " + paths[0] + " do katalogu " + c.getPath());
        } catch (Exception e) {
            System.out.println("Nie udalo sie przeniesc. " + e.getMessage());
        }
    }
}