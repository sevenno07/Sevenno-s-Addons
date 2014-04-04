package sevenno_addons.common.dimension;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SAD_GrassBlock
{
    private static int[] grassBuffer = new int[65536];

    public static void setGrassBiomeColorizer(int[] par0ArrayOfInteger)
    {
        grassBuffer = par0ArrayOfInteger;
    }

    public static int getGrassColor(double par0, double par2)
    {
        par2 *= par0;
        int i = (int)((1.0D - par0) * 255.0D);
        int j = (int)((1.0D - par2) * 255.0D);
        return grassBuffer[j << 8 | i];
    }
}