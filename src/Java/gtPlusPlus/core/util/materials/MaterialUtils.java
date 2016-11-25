package gtPlusPlus.core.util.materials;

import gregtech.api.enums.*;
import gregtech.api.enums.TC_Aspects.TC_AspectStack;
import gregtech.api.objects.MaterialStack;
import gtPlusPlus.core.material.Material;
import gtPlusPlus.core.util.Utils;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;

public class MaterialUtils {
	
	public static short firstID = 791;

	private static Class[][] commonTypes =
		{{Materials.class, int.class, TextureSet.class, float.class, int.class,
			int.class, int.class, int.class, int.class, int.class, int.class,
			String.class, int.class, int.class, int.class, int.class, boolean.class,
			boolean.class, int.class, int.class, int.class, Dyes.class, int.class,
			List.class , List.class}};
	
	public static Materials addGtMaterial(String enumNameForMaterial, TextureSet aIconSet, float aToolSpeed, int aToolDurability, int aToolQuality, int aTypes, int aR, int aG, int aB, int aA, String aLocalName, int aFuelType, int aFuelPower, int aMeltingPoint, int aBlastFurnaceTemp, boolean aBlastFurnaceRequired, boolean aTransparent, int aOreValue, int aDensityMultiplier, int aDensityDivider, Dyes aColor, int aExtraData, List<MaterialStack> aMaterialList, List<TC_AspectStack> aAspects)
    {
		Utils.LOG_INFO("Attempting to add GT material: "+enumNameForMaterial);
		return EnumHelper.addEnum(Materials.class, enumNameForMaterial, commonTypes, firstID++, aIconSet, aToolSpeed, aToolDurability, aToolQuality, aTypes, aR, aG, aB, aA, aLocalName,
				aFuelType, aFuelPower, aMeltingPoint, aBlastFurnaceTemp, aBlastFurnaceRequired, aTransparent, aOreValue, aDensityMultiplier, aDensityDivider,
				aColor, aExtraData, aMaterialList, aAspects);
		}
	
	public static List<?> oreDictValuesForEntry(String oredictName){
		List<?> oredictItemNames;
		if(OreDictionary.doesOreNameExist(oredictName)){
			ArrayList<ItemStack> oredictItems = OreDictionary.getOres(oredictName);
			oredictItemNames = Utils.convertArrayListToList(oredictItems);
			return oredictItemNames;
		}		
		return null;
	}
	
	public static Material generateMaterialFromGtENUM(Materials material){
		String name = material.name();
		short[] rgba = material.mRGBa;
		int melting = material.mMeltingPoint;
		int boiling = material.mBlastFurnaceTemp;
		long protons = material.getProtons();
		long neutrons = material.getNeutrons();
		boolean blastFurnace = material.mBlastFurnaceRequired;	
		String chemicalFormula = material.mChemicalFormula;
		Element element = material.mElement;
		int radioactivity = 0;
		if (material.isRadioactive()){
			radioactivity = 1;
		}		
		if (hasValidRGBA(rgba) || element == Element.H || (material == Materials.InfusedAir || material == Materials.InfusedFire || material == Materials.InfusedEarth || material == Materials.InfusedWater)){
			//ModItems.itemBaseDecidust = UtilsItems.generateDecidust(material);
			//ModItems.itemBaseCentidust = UtilsItems.generateCentidust(material);
			return new Material(name, rgba, melting, boiling, protons, neutrons, blastFurnace, chemicalFormula, radioactivity);
		}
		return null;
		
	}
	
	public static Material generateQuickMaterial(String materialName, short[] colour, int sRadioactivity) {
		Material temp = new Material(
				materialName,
				colour,
				1000, //melting
				3000, //boiling
				50, //Protons
				50, //Neutrons
				false,
				"",
				sRadioactivity);
		return temp;
	}
	
	public static boolean hasValidRGBA(short[] rgba){
		boolean test1 = false;
		boolean test2 = false;
		boolean test3 = false;		
		for (int r=0;r<rgba.length;r++){
			if (rgba[r] == 0){
				if (r == 0){
					test1 = true;
				}
				else if (r == 1){
					test2 = true;					
				}
				else if (r == 2){
					test3 = true;					
				}
			}
		}		
		if ((test1 && test2) || (test1 && test3) || (test3 && test2)){
			return false;
		}
		return true;
	}
	
	public static String superscript(String str) {
	    str = str.replaceAll("0", "\u2070");
	    str = str.replaceAll("1", "\u00B9");
	    str = str.replaceAll("2", "\u00B2");
	    str = str.replaceAll("3", "\u00B3");
	    str = str.replaceAll("4", "\u2074");
	    str = str.replaceAll("5", "\u2075");
	    str = str.replaceAll("6", "\u2076");
	    str = str.replaceAll("7", "\u2077");
	    str = str.replaceAll("8", "\u2078");
	    str = str.replaceAll("9", "\u2079");      
	    return str;
	}

	public static String subscript(String str) {
	    str = str.replaceAll("0", "\u2080");
	    str = str.replaceAll("1", "\u2081");
	    str = str.replaceAll("2", "\u2082");
	    str = str.replaceAll("3", "\u2083");
	    str = str.replaceAll("4", "\u2084");
	    str = str.replaceAll("5", "\u2085");
	    str = str.replaceAll("6", "\u2086");
	    str = str.replaceAll("7", "\u2087");
	    str = str.replaceAll("8", "\u2088");
	    str = str.replaceAll("9", "\u2089");
	    return str;
	}
	
	public static int getTierOfMaterial(int M){
		if (M >= 0 && M <= 750){
			return 1;
		}
		else if(M >= 751 && M <= 1250){
			return 2;
		}
		else if(M >= 1251 && M <= 1750){
			return 3;
		}
		else if(M >= 1751 && M <= 2250){
			return 4;
		}
		else if(M >= 2251 && M <= 2750){
			return 5;
		}
		else if(M >= 2751 && M <= 3250){
			return 6;
		}
		else if(M >= 3251 && M <= 3750){
			return 7;
		}
		else if(M >= 3751 && M <= 4250){
			return 8;
		}
		else if(M >= 4251 && M <= 4750){
			return 9;
		}
		else if(M >= 4751 && M <= 9999){
			return 10;
		}
		else {
			return 0;
		}
	}
	

	/*
	 * That's shown, many times, in the EnumHelper code, all the add functions just wrap the addEnum function.
	You need the target enum class, and 2 arrays, 1 holding the types for the constructor arguments, 
	and the other holding the constructor argument values (the things being passed to the constructor)

	The 'decompiled' Boolean should be set to true if the class you're adding to has been decompiled/recompiled again. 
	(it adds a 2nd enum arguments that need to be accounted for, but isn't actually useful to you) 

	 *
	 *new Class[{int.class, TextureSet.class, float.class, int.class,
	int.class, int.class, int.class, int.class, int.class, int.class,
	String.class, int.class, int.class, int.class, int.class, boolean.class,
	boolean.class, int.class, int.class, int.class, Dyes.class, int.class,
					List.class , List.class}],
	 */

	

	/*public static Materials GenerateGtMaterialForSingleUse(MaterialInfo s){

		Materials yourName = EnumHelper.addEnum(

				Materials.class, s.name(),



				new Object[0]

				);
		try
		{



			Class<? extends ItemCell> clz = item.getClass();
			Method methode = clz.getDeclaredMethod("addCell", int.class, InternalName.class, Block[].class);
			methode.setAccessible(true);
			ItemStack temp = (ItemStack) methode.invoke(item, cellID++, yourName, new Block[0]);






			return Materials.Abyssal;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}*/

}