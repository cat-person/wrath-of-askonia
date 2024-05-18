package woa.hullmods;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.combat.listeners.FighterOPCostModifier;
import com.fs.starfarer.api.loading.FighterWingSpecAPI;

public class AndradaDefenseInitiativeHullMod extends BaseHullMod {
    @Override
    public void applyEffectsBeforeShipCreation(ShipAPI.HullSize hullSize, MutableShipStatsAPI stats, String id) {
        super.applyEffectsBeforeShipCreation(hullSize, stats, id);
        stats.addListener(new MannedFighterFilter());
    }

    @Override
    public void applyEffectsToFighterSpawnedByShip(ShipAPI fighter, ShipAPI ship, String id) {
        super.applyEffectsToFighterSpawnedByShip(fighter, ship, id);
//        fighter.getMutableStats().getFighterWingRange().modifyMult("AndradaDefenseInitiativeHullMod", 0f);
//        fighter.getMutableStats().getShieldDamageTakenMult().modifyMult("AndradaDefenseInitiativeHullMod", 0.0f);
//        fighter.getMutableStats().getArmorDamageTakenMult().modifyMult("AndradaDefenseInitiativeHullMod", 0.0f);
//        fighter.getMutableStats().getBeamPDWeaponRangeBonus().modifyFlat("AndradaDefenseInitiativeHullMod", 20f);
//        fighter.getMutableStats().getDamageToFighters().modifyMult("AndradaDefenseInitiativeHullMod", 1.5f);
    }

    @Override
    public boolean affectsOPCosts() {
        return true;
    }

    static class MannedFighterFilter implements FighterOPCostModifier {
        @Override
        public int getFighterOPCost(MutableShipStatsAPI stats, FighterWingSpecAPI fighter, int currCost) {
            if(fighter.hasTag("auto_fighter") && !fighter.isBomber()) {
                return currCost;
            }
            return 10000;
        }
    }
}
