package j3ff97.elementalmelons.fluids;

import net.minecraftforge.fluids.Fluid;

public class FluidEM extends Fluid
{
    public FluidEM(String fluidName, int luminosity, int viscosity, boolean gas)
    {
        super(fluidName);
        this.setLuminosity(luminosity);
        this.setViscosity(viscosity);
        this.setGaseous(gas);
    }
}
