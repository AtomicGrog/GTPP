package gtPlusPlus.core.item;
import static gtPlusPlus.core.creative.AddToCreativeTab.tabMachines;
import static gtPlusPlus.core.creative.AddToCreativeTab.tabMisc;
import static gtPlusPlus.core.lib.CORE.LOAD_ALL_CONTENT;
import gregtech.api.enums.Materials;
import gregtech.api.util.GT_OreDictUnificator;
import gtPlusPlus.core.common.compat.COMPAT_Baubles;
import gtPlusPlus.core.creative.AddToCreativeTab;
import gtPlusPlus.core.item.base.*;
import gtPlusPlus.core.item.base.dusts.decimal.BaseItemCentidust;
import gtPlusPlus.core.item.base.dusts.decimal.BaseItemDecidust;
import gtPlusPlus.core.item.base.foods.BaseItemFood;
import gtPlusPlus.core.item.base.foods.BaseItemHotFood;
import gtPlusPlus.core.item.base.ingots.BaseItemIngot;
import gtPlusPlus.core.item.base.plates.BaseItemPlate;
import gtPlusPlus.core.item.effects.RarityUncommon;
import gtPlusPlus.core.item.general.*;
import gtPlusPlus.core.item.general.fuelrods.FuelRod_Base;
import gtPlusPlus.core.item.init.ItemsFoods;
import gtPlusPlus.core.item.tool.misc.SandstoneHammer;
import gtPlusPlus.core.item.tool.staballoy.*;
import gtPlusPlus.core.lib.*;
import gtPlusPlus.core.lib.CORE.configSwitches;
import gtPlusPlus.core.material.*;
import gtPlusPlus.core.util.Utils;
import gtPlusPlus.core.util.debug.DEBUG_INIT;
import gtPlusPlus.core.util.item.ItemUtils;
import net.minecraft.item.*;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;
public final class ModItems {

	public static ToolMaterial STABALLOY = EnumHelper.addToolMaterial("Staballoy", 3, 2500, 7, 1.0F, 18);

	public static Item AAA_Broken;

	public static Item itemDebugShapeSpawner;

	public static Item itemBaseSpawnEgg;

	//EnderIO
	public static Item itemPlateSoularium;
	public static Item itemPlateRedstoneAlloy;
	public static Item itemPlateElectricalSteel;
	public static Item itemPlatePulsatingIron;
	public static Item itemPlateEnergeticAlloy;
	public static Item itemPlateVibrantAlloy;
	public static Item itemPlateConductiveIron;
	public static Item itemPlateDarkSteel;
	//Big Reactors
	public static Item itemPlateBlutonium;
	public static Item itemPlateCyanite;
	public static Item itemPlateLudicrite;
	//Thaumcraft
	public static Item itemPlateVoidMetal;
	//Pneumaticraft
	public static Item itemPlateCompressedIron;
	//SimplyJetpacks
	public static Item itemPlateEnrichedSoularium;
	//rfTools
	public static Item itemPlateDimensionShard;
	//Staballoy
	public static Item itemStaballoyPickaxe;
	public static Item itemStaballoyAxe;
	//Tools
	public static Item itemSandstoneHammer;
	//Machine Related
	public static Item itemBufferCore0;
	//Material related
	public static Item itemStickyRubber;
	public static Item itemIngotBatteryAlloy;
	public static Item itemPlateBatteryAlloy;
	public static Item itemHeliumBlob;
	public static Item itemHydrogenBlob;
	public static Item itemPLACEHOLDER_Circuit;

	public static Item FuelRod_Empty;
	public static Item FuelRod_Thorium;
	public static Item FuelRod_Uranium;
	public static Item FuelRod_Plutonium;

	public static Item itemBedLocator_Base;
	public static Item itemBaseItemWithCharge;

	public static Item itemIngotRaisinBread;
	public static Item itemHotIngotRaisinBread;

	public static ItemFood itemFoodRaisinToast;
	public static BaseItemHotFood itemHotFoodRaisinToast;
	public static BaseItemFood itemFoodCurriedSausages;
	public static BaseItemHotFood itemHotFoodCurriedSausages;

	public static Item RfEuBattery;
	public static Item itemPersonalCloakingDevice;
	public static Item itemPersonalCloakingDeviceCharged;
	public static Item itemPersonalHealingDevice;

	public static MultiPickaxeBase MP_GTMATERIAL;
	public static MultiSpadeBase MS_GTMATERIAL;
	
	public static BaseItemDecidust itemBaseDecidust;
	public static BaseItemCentidust itemBaseCentidust;

	public static ItemStack FluidCell;

	public static BaseItemBackpack backpack_Red;
	public static BaseItemBackpack backpack_Green;
	public static BaseItemBackpack backpack_Blue;
	public static BaseItemBackpack backpack_Yellow;
	public static BaseItemBackpack backpack_Purple;
	public static BaseItemBackpack backpack_Cyan;
	public static BaseItemBackpack backpack_Maroon;
	public static BaseItemBackpack backpack_Olive;
	public static BaseItemBackpack backpack_DarkGreen;
	public static BaseItemBackpack backpack_DarkPurple;
	public static BaseItemBackpack backpack_Teal;
	public static BaseItemBackpack backpack_Navy;
	public static BaseItemBackpack backpack_Silver;
	public static BaseItemBackpack backpack_Gray;
	public static BaseItemBackpack backpack_Black;
	public static BaseItemBackpack backpack_White;

	public static ItemBlueprint itemBlueprintBase;

	public static Item dustLithiumCarbonate;
	public static Item dustLithiumHydroxide;
	public static Item dustLithiumPeroxide;
	public static Item dustLithiumFluoride;

	public static Item dustUraniumTetraFluoride;
	public static Item dustUraniumHexaFluoride;

	public static Item dustBerylliumFluoride;

	public static Item dustQuicklime;
	public static Item dustCalciumHydroxide;
	public static Item dustCalciumCarbonate;
	public static Item dust2LiOH_CaCO3;
	public static Item dustLi2BeF4;
	
	public static Item dustAer;
	public static Item dustIgnis;
	public static Item dustTerra;
	public static Item dustAqua;
	
	public static BaseEuItem metaItem2;


	//@SuppressWarnings("unused")
	@SuppressWarnings("unused")
	public static final void init(){

		//Default item used when recipes fail, handy for debugging.
		AAA_Broken = new BaseItemIngot("AAA_Broken", "Errors - Tell Alkalus", Utils.rgbtoHexValue(128, 128, 128), 0);

		//Debug Loading
		if (CORE.DEBUG){
			DEBUG_INIT.registerItems();
		}		
		
		
		//Some Simple forms of materials
		itemStickyRubber = new Item().setUnlocalizedName("itemStickyRubber").setCreativeTab(tabMachines).setTextureName(CORE.MODID + ":itemStickyRubber");
		GameRegistry.registerItem(itemStickyRubber, "itemStickyRubber");
		GT_OreDictUnificator.registerOre("ingotRubber", ItemUtils.getItemStack(CORE.MODID+":itemStickyRubber", 1));

		
		
		
		
		
		//Register Hydrogen Blobs first, so we can replace old helium blobs.
		itemHydrogenBlob = new CoreItem("itemHydrogenBlob", tabMisc).setTextureName(CORE.MODID + ":itemHydrogenBlob");
		GT_OreDictUnificator.registerOre("dustHydrogen", new ItemStack(ModItems.itemHydrogenBlob));
		//Register Old Helium Blob, this will be replaced when held by a player.
		itemHeliumBlob = new CoreItem("itemHeliumBlob", tabMisc, ItemUtils.getSimpleStack(itemHydrogenBlob)).setTextureName(CORE.MODID + ":itemHeliumBlob");
		
		
		//Make some backpacks
		//Primary colours
		backpack_Red = new BaseItemBackpack("backpackRed", Utils.rgbtoHexValue(200, 0, 0));
		backpack_Green = new BaseItemBackpack("backpackGreen", Utils.rgbtoHexValue(0, 200, 0));
		backpack_Blue = new BaseItemBackpack("backpackBlue", Utils.rgbtoHexValue(0, 0, 200));
		//Secondary Colours
		backpack_Yellow = new BaseItemBackpack("backpackYellow", Utils.rgbtoHexValue(200, 200, 0));
		backpack_Purple = new BaseItemBackpack("backpackPurple", Utils.rgbtoHexValue(200, 0, 200));
		backpack_Cyan = new BaseItemBackpack("backpackCyan", Utils.rgbtoHexValue(0, 200, 200));
		//Tertiary Colours
		backpack_Maroon = new BaseItemBackpack("backpackMaroon", Utils.rgbtoHexValue(128, 0, 0));
		backpack_Olive = new BaseItemBackpack("backpackOlive", Utils.rgbtoHexValue(128, 128, 0));
		backpack_DarkGreen = new BaseItemBackpack("backpackDarkGreen", Utils.rgbtoHexValue(0, 128, 0));
		backpack_DarkPurple = new BaseItemBackpack("backpackDarkPurple", Utils.rgbtoHexValue(128, 0, 128));
		backpack_Teal = new BaseItemBackpack("backpackTeal", Utils.rgbtoHexValue(0, 128, 128));
		backpack_Navy = new BaseItemBackpack("backpackNavy", Utils.rgbtoHexValue(0, 0, 128));
		//Shades
		backpack_Silver = new BaseItemBackpack("backpackSilver", Utils.rgbtoHexValue(192, 192, 192));
		backpack_Gray = new BaseItemBackpack("backpackGray", Utils.rgbtoHexValue(128, 128, 128));
		backpack_Black = new BaseItemBackpack("backpackBlack", Utils.rgbtoHexValue(20, 20, 20));
		backpack_White = new BaseItemBackpack("backpackWhite", Utils.rgbtoHexValue(240, 240, 240));

		itemBlueprintBase = new ItemBlueprint("itemBlueprint");

		//Start meta Item Generation
		ItemsFoods.load();

		try{
			//Elements generate first so they can be used in compounds.
				     		
			//Uranium-233 is a fissile isotope of uranium that is bred from thorium-232 as part of the thorium fuel cycle.
	        MaterialGenerator.generate(ELEMENT.getInstance().URANIUM233);
	        MaterialGenerator.generate(ELEMENT.getInstance().ZIRCONIUM);
			
			//Carbides - Tungsten Carbide exists in .09 so don't generate it. - Should still come before alloys though
			if (!CORE.MAIN_GREGTECH_5U_EXPERIMENTAL_FORK){
				MaterialGenerator.generate(ALLOY.TUNGSTEN_CARBIDE);
			}
			MaterialGenerator.generate(ALLOY.SILICON_CARBIDE);
			MaterialGenerator.generate(ALLOY.ZIRCONIUM_CARBIDE);
			MaterialGenerator.generate(ALLOY.TANTALUM_CARBIDE);
			MaterialGenerator.generate(ALLOY.NIOBIUM_CARBIDE);	
			
			//Generate some Alloys
			
			//Misc Alloys
			MaterialGenerator.generate(ALLOY.ENERGYCRYSTAL);
			MaterialGenerator.generate(ALLOY.BLOODSTEEL);
			MaterialGenerator.generate(ALLOY.BEDROCKIUM);
			MaterialGenerator.generate(ALLOY.ZERON_100);
			//Tumbaga was the name given by Spaniards to a non-specific alloy of gold and copper 
			MaterialGenerator.generate(ALLOY.TUMBAGA);
			//Potin is traditionally an alloy of bronze, tin and lead, with varying quantities of each possible
			MaterialGenerator.generate(ALLOY.POTIN);
			
			//Staballoy & Tantalloy
			MaterialGenerator.generate(ALLOY.STABALLOY);
			MaterialGenerator.generate(ALLOY.TANTALLOY_60);
			MaterialGenerator.generate(ALLOY.TANTALLOY_61);

			//Inconel
			MaterialGenerator.generate(ALLOY.INCONEL_625);
			MaterialGenerator.generate(ALLOY.INCONEL_690);
			MaterialGenerator.generate(ALLOY.INCONEL_792);

			
			//Maraging Steel
			MaterialGenerator.generate(ALLOY.MARAGING250);
			MaterialGenerator.generate(ALLOY.MARAGING300);
			MaterialGenerator.generate(ALLOY.MARAGING350);
			
			//Composite Alloys
			MaterialGenerator.generate(ALLOY.STELLITE);
			MaterialGenerator.generate(ALLOY.TALONITE);			

			//Hastelloy
			MaterialGenerator.generate(ALLOY.HASTELLOY_W);
			MaterialGenerator.generate(ALLOY.HASTELLOY_X);
			MaterialGenerator.generate(ALLOY.HASTELLOY_C276);
			MaterialGenerator.generate(ALLOY.HASTELLOY_N);

			//Incoloy
			MaterialGenerator.generate(ALLOY.INCOLOY_020);
			MaterialGenerator.generate(ALLOY.INCOLOY_DS);
			MaterialGenerator.generate(ALLOY.INCOLOY_MA956);
			
			//Leagrisium
			MaterialGenerator.generate(ALLOY.LEAGRISIUM);			
			//Must be the final Alloy to Generate
			MaterialGenerator.generate(ALLOY.QUANTUM);		
			

		} catch (Throwable r){
			Utils.LOG_INFO("Failed to Generated a Material. "+r.getMessage());
			//Utils.LOG_INFO("Failed to Generated a Material. "+r.getCause().getMessage());
			Utils.LOG_INFO("Failed to Generated a Material. "+r.getStackTrace()[0].getMethodName());
			Utils.LOG_INFO("Failed to Generated a Material. "+r.getStackTrace()[1].getMethodName());
			r.printStackTrace();
			System.exit(1);
		}


		//Energy Crystal Components
		dustAer = ItemUtils.generateSpecialUseDusts(ELEMENT.getInstance().AER, true)[0];
		dustIgnis = ItemUtils.generateSpecialUseDusts(ELEMENT.getInstance().IGNIS, true)[0];
		dustTerra = ItemUtils.generateSpecialUseDusts(ELEMENT.getInstance().TERRA, true)[0];
		dustAqua = ItemUtils.generateSpecialUseDusts(ELEMENT.getInstance().AQUA, true)[0];

		//Nuclear Fuel Dusts
		dustUraniumTetraFluoride = ItemUtils.generateSpecialUseDusts("UraniumTetrafluoride", "Uranium Tetrafluoride", Utils.rgbtoHexValue(17, 179, 42))[0];
		dustUraniumHexaFluoride = ItemUtils.generateSpecialUseDusts("UraniumHexafluoride", "Uranium Hexafluoride", Utils.rgbtoHexValue(9, 199, 32))[0];

		dustBerylliumFluoride = ItemUtils.generateSpecialUseDusts("BerylliumFluoride", "Beryllium Fluoride", Utils.rgbtoHexValue(175, 175, 175))[0]; //https://en.wikipedia.org/wiki/Beryllium_fluoride

		dustLithiumCarbonate = ItemUtils.generateSpecialUseDusts("LithiumCarbonate", "Lithium Carbonate", Utils.rgbtoHexValue(240, 240, 240))[0]; //https://en.wikipedia.org/wiki/Lithium_carbonate
		dustLithiumFluoride = ItemUtils.generateSpecialUseDusts("LithiumFluoride", "Lithium Fluoride", Utils.rgbtoHexValue(245, 245, 245))[0]; //https://en.wikipedia.org/wiki/Lithium_fluoride
		dustLithiumPeroxide = ItemUtils.generateSpecialUseDusts("LithiumPeroxide", "Lithium Peroxide", Utils.rgbtoHexValue(250, 250, 250))[0]; //https://en.wikipedia.org/wiki/Lithium_peroxide
		dustLithiumHydroxide = ItemUtils.generateSpecialUseDusts("LithiumHydroxide", "Lithium Hydroxide", Utils.rgbtoHexValue(250, 250, 250))[0]; //https://en.wikipedia.org/wiki/Lithium_hydroxide

		if (ItemUtils.getItemStackOfAmountFromOreDict("dustQuicklime", 1).getItem() == ModItems.AAA_Broken || !LoadedMods.IHL){
			dustQuicklime = ItemUtils.generateSpecialUseDusts("Quicklime", "Quicklime", Utils.rgbtoHexValue(255, 255, 255))[0]; //https://en.wikipedia.org/wiki/Calcium_oxide
		}
		dustCalciumHydroxide = ItemUtils.generateSpecialUseDusts("CalciumHydroxide", "Hydrated Lime", Utils.rgbtoHexValue(255, 255, 255))[0]; //https://en.wikipedia.org/wiki/Calcium_hydroxide
		dustCalciumCarbonate = ItemUtils.generateSpecialUseDusts("CalciumCarbonate", "Calcium Carbonate", Utils.rgbtoHexValue(255, 255, 255))[0]; //https://en.wikipedia.org/wiki/Calcium_carbonate
		dust2LiOH_CaCO3 = ItemUtils.generateSpecialUseDusts("2LiOHCaCO3", "2LiOH & CaCO3 Compound", Utils.rgbtoHexValue(255, 255, 255))[0]; //https://en.wikipedia.org/wiki/Calcium_carbonate
		
		//FLiBe Fuel Compounds
		dustLi2BeF4 = ItemUtils.generateSpecialUseDusts("Li2BeF4", "Li2BeF4 Fuel Compound", Utils.rgbtoHexValue(255, 255, 255))[0]; //https://en.wikipedia.org/wiki/FLiBe

		metaItem2 = new BaseEuItem();
		metaItem2.registerItem(0, EnumChatFormatting.BLACK+"Test Item 0", 0, 0, "I am 0.");
		metaItem2.registerItem(1, EnumChatFormatting.GREEN+"Test Item 1", 1006346000, 1, "I Hold EU 1.", 500);
		metaItem2.registerItem(2, EnumChatFormatting.GOLD+"Test Item 2", 1004630000, 2, "I Hold EU 2.", 8000);
		metaItem2.registerItem(3, "Test Item 3", 1000765000, 4, "I Hold EU 3.", 32000);
		metaItem2.registerItem(4, "Whirlygig", 1043644000, (short) 5, "Spin me right round.", EnumRarity.rare, EnumChatFormatting.DARK_GREEN, true);
		metaItem2.registerItem(5, "Whirlygig 2", 2124867000, (short) 7, "Spin me right round.", EnumRarity.uncommon, EnumChatFormatting.RED, true);
	
		// ItemList.Battery_RE_HV_Cadmium.set(BaseEuItem.

		//GameRegistry.registerItem(this, unlocalName);
		
		boolean gtStyleTools = LoadedMods.Gregtech;

		Materials[] rm = Materials.values();
		for (Materials m : rm){
			MP_GTMATERIAL = ItemUtils.generateMultiPick(gtStyleTools, m);
			MS_GTMATERIAL = ItemUtils.generateMultiShovel(gtStyleTools, m);
			/*itemBaseDecidust = UtilsItems.generateDecidust(m);
			itemBaseCentidust = UtilsItems.generateCentidust(m);*/
		}

		//EnderIO Resources
		if (LoadedMods.EnderIO || LOAD_ALL_CONTENT){
			Utils.LOG_INFO("EnderIO Found - Loading Resources.");
			//Item Init
			itemPlateSoularium = new BaseItemPlate("itemPlate"+"Soularium", "Soularium", new short[]{95, 90, 54}, 2, 0);
			itemPlateRedstoneAlloy = new BaseItemPlate("itemPlate"+"RedstoneAlloy", "Redstone Alloy", new short[]{178,34,34}, 2, 0);
			itemPlateElectricalSteel =new BaseItemPlate("itemPlate"+"ElectricalSteel", "Electrical Steel", new short[]{194, 194, 194}, 2, 0);
			itemPlatePulsatingIron = new BaseItemPlate("itemPlate"+"PhasedIron", "Phased Iron", new short[]{50, 91, 21}, 2, 0);
			itemPlateEnergeticAlloy = new BaseItemPlate("itemPlate"+"EnergeticAlloy", "Energetic Alloy", new short[]{252, 152, 45}, 2, 0);
			itemPlateVibrantAlloy = new BaseItemPlate("itemPlate"+"VibrantAlloy", "Vibrant Alloy", new short[]{204, 242, 142}, 2, 0);
			itemPlateConductiveIron = new BaseItemPlate("itemPlate"+"ConductiveIron", "Conductive Iron", new short[]{164, 109, 100}, 2, 0);

		}
		else {
			Utils.LOG_WARNING("EnderIO not Found - Skipping Resources.");
		}
		//Big Reactors
		if (LoadedMods.Big_Reactors|| LOAD_ALL_CONTENT){
			Utils.LOG_INFO("BigReactors Found - Loading Resources.");
			//Item Init
			itemPlateBlutonium = new BaseItemPlate("itemPlate"+"Blutonium", "Blutonium", new short[]{0, 0, 255}, 2, 0);
			itemPlateCyanite = new BaseItemPlate("itemPlate"+"Cyanite", "Cyanite", new short[]{0, 191, 255}, 2, 0);
			itemPlateLudicrite = new BaseItemPlate("itemPlate"+"Ludicrite", "Ludicrite", new short[]{167, 5, 179}, 2, 0);

		}
		else {
			Utils.LOG_WARNING("BigReactors not Found - Skipping Resources.");
		}
		//Thaumcraft
		if (LoadedMods.Thaumcraft|| LOAD_ALL_CONTENT){
			Utils.LOG_INFO("Thaumcraft Found - Loading Resources.");
			//Item Init
			try {

				ItemUtils.getItemForOreDict("Thaumcraft:ItemResource", "ingotVoidMetal", "Void Metal Ingot", 16);				
				itemPlateVoidMetal = new BaseItemPlate("itemPlate"+"Void", "Void", new short[]{82, 17, 82}, 2, 0);
				GT_OreDictUnificator.registerOre("plateVoidMetal", new ItemStack(ModItems.itemPlateVoidMetal));
			} catch (NullPointerException e){
				e.getClass();
			}

		}
		else {
			Utils.LOG_WARNING("Thaumcraft not Found - Skipping Resources.");
		}
		//ExtraUtils
		if (LoadedMods.Extra_Utils|| LOAD_ALL_CONTENT){
			Utils.LOG_INFO("ExtraUtilities Found - Loading Resources.");
			//Item Init
			try {
				//itemPlateBedrockium = new Item().setUnlocalizedName("itemPlateBedrockium").setCreativeTab(AddToCreativeTab.tabMisc).setTextureName(CORE.MODID + ":itemPlateBedrockium");
			} catch (NullPointerException e){
				e.getClass();
			}
			//Registry
			//GameRegistry.registerItem(itemPlateBedrockium, "itemPlateBedrockium");
		}
		else {
			Utils.LOG_WARNING("ExtraUtilities not Found - Skipping Resources.");
		}
		//Pneumaticraft
		if (LoadedMods.PneumaticCraft|| LOAD_ALL_CONTENT){
			Utils.LOG_INFO("PneumaticCraft Found - Loading Resources.");
			//Item Init
			itemPlateCompressedIron = new BaseItemPlate("itemPlate"+"CompressedIron", "Compressed Iron", new short[]{128, 128, 128}, 2, 0);
		}
		else {
			Utils.LOG_WARNING("PneumaticCraft not Found - Skipping Resources.");
		}
		//Simply Jetpacks
		if (LoadedMods.Simply_Jetpacks|| LOAD_ALL_CONTENT){
			Utils.LOG_INFO("SimplyJetpacks Found - Loading Resources.");
			//Item Init
			itemPlateEnrichedSoularium = new RarityUncommon().setUnlocalizedName("itemPlateEnrichedSoularium").setCreativeTab(AddToCreativeTab.tabMisc).setTextureName(CORE.MODID + ":itemPlateSoularium");
			//Registry
			GameRegistry.registerItem(itemPlateEnrichedSoularium, "itemPlateEnrichedSoularium");
		}
		else {
			Utils.LOG_WARNING("SimplyJetpacks not Found - Skipping Resources.");
		}
		//rfTools
		if (LoadedMods.RFTools|| LOAD_ALL_CONTENT){
			Utils.LOG_INFO("rfTools Found - Loading Resources.");
			//Item Init
			itemPlateDimensionShard = new BaseItemPlate("itemPlate"+"DimensionShard", "Dimensional Shard", new short[]{170, 230, 230}, 2, 0);
		}
		else {
			Utils.LOG_WARNING("rfTools not Found - Skipping Resources.");
		}
		//IC2 Exp
		if (LoadedMods.IndustrialCraft2|| LOAD_ALL_CONTENT){
			Utils.LOG_INFO("IndustrialCraft2 Found - Loading Resources.");
			//Item Init
			FuelRod_Empty = new FuelRod_Base("itemFuelRod_Empty", "Empty", 0, 1000);
			FuelRod_Thorium = new FuelRod_Base("itemFuelRod_Thorium", "Thorium", 1000, 1000);
			FuelRod_Uranium = new FuelRod_Base("itemFuelRod_Uranium", "Uranium", 2500, 2500);
			FuelRod_Plutonium = new FuelRod_Base("itemFuelRod_Plutonium", "Plutonium", 5000, 5000);
			RfEuBattery = new RF2EU_Battery();

			try {Class baublesTest = Class.forName("baubles.api.IBauble");
			if (baublesTest != null){					
				COMPAT_Baubles.run();
			}
			else {
				Utils.LOG_INFO("Baubles Not Found - Skipping Resources.");					
			}
			} catch(Throwable T){
				Utils.LOG_INFO("Baubles Not Found - Skipping Resources.");				
			}
			//Registry
			//GameRegistry.registerItem(FuelRod_Empty, "itemFuelRod_Empty");
			//GameRegistry.registerItem(FuelRod_Thorium, "itemFuelRod_Thorium");
			//GameRegistry.registerItem(FuelRod_Uranium, "itemFuelRod_Uranium");
			//GameRegistry.registerItem(FuelRod_Plutonium, "itemFuelRod_Plutonium");

			//FluidCell = new ItemStack(new IC2_ItemFluidCell("itemGT++FluidCell"));


		}
		else {
			Utils.LOG_WARNING("IndustrialCraft2 not Found - Skipping Resources.");
		}


		//Special Item Handling Case
		if (configSwitches.enableAlternativeBatteryAlloy) {
			//ModItems.itemIngotBatteryAlloy = new BaseItemIngot("itemIngotBatteryAlloy", "Battery Alloy", new short[]{35, 228, 141}, 0); TODO
			ModItems.itemPlateBatteryAlloy = new BaseItemPlate("itemPlateBatteryAlloy", "Battery Alloy", new short[]{35, 228, 141}, 2, 0);
		}


		//UtilsItems.generateSpawnEgg("ic2", "boatcarbon", Utils.generateSingularRandomHexValue(), Utils.generateSingularRandomHexValue());



		/*
		 * Misc Items
		 */

		//Staballoy Equipment
		itemStaballoyPickaxe = new StaballoyPickaxe("itemStaballoyPickaxe", STABALLOY).setCreativeTab(AddToCreativeTab.tabTools);
		GameRegistry.registerItem(itemStaballoyPickaxe, itemStaballoyPickaxe.getUnlocalizedName());
		itemStaballoyAxe = new StaballoyAxe("itemStaballoyAxe", STABALLOY).setCreativeTab(AddToCreativeTab.tabTools);
		GameRegistry.registerItem(itemStaballoyAxe, itemStaballoyAxe.getUnlocalizedName());

		//Sandstone Hammer
		itemSandstoneHammer = new SandstoneHammer("itemSandstoneHammer").setCreativeTab(AddToCreativeTab.tabTools);
		GameRegistry.registerItem(itemSandstoneHammer, itemSandstoneHammer.getUnlocalizedName());

		//Buffer Cores!
		Item itemBufferCore;
		for(int i=1; i<=10; i++){
			//Utils.LOG_INFO(""+i);
			itemBufferCore = new BufferCore("itemBufferCore", i).setCreativeTab(AddToCreativeTab.tabMachines);
			GameRegistry.registerItem(itemBufferCore, itemBufferCore.getUnlocalizedName()+i);
			//System.out.println("Buffer Core registration count is: "+i);
		}

		itemPLACEHOLDER_Circuit = new Item().setUnlocalizedName("itemPLACEHOLDER_Circuit").setTextureName(CORE.MODID + ":itemPLACEHOLDER_Circuit");
		GameRegistry.registerItem(itemPLACEHOLDER_Circuit, "itemPLACEHOLDER_Circuit");

		//ItemBlockGtFrameBox = new ItemBlockGtFrameBox(ModBlocks.blockGtFrameSet1);
		//GameRegistry.registerItem(ItemBlockGtFrameBox, "itemGtFrameBoxSet1");		
	}
}