package pl.retsuz.shell.variations.mkdir;

import pl.retsuz.filesystem.Composite;
import pl.retsuz.filesystem.IComposite;
import pl.retsuz.shell.gen.ICommand;
import pl.retsuz.shell.variations.gen.CommandVariation;
import pl.retsuz.shell.variations.gen.ICommandVariation;

public class Mkdir_Path extends CommandVariation {
    public Mkdir_Path(ICommandVariation next, ICommand parent) {
        super(next,parent,"[a-zA-Z0-9.l\\/_]*");
    }
    @Override
    public void make(String params) {

        Composite c= (Composite) (this.getParent().getContext().getCurrent());
        String path = params.substring(0, params.lastIndexOf("/"));
        String name = params.substring(params.lastIndexOf("/") + 1);
        IComposite dir = new Composite();
        dir.setName(name);
        try{
            IComposite p = c.findElementByPath(path);
            ((Composite) p).addElement(dir);
            System.out.println("Utworzono katalog " + params);
        }
        catch (Exception e)
        {
            System.out.println("Cos poszlo nie tak");
        }

    }
}