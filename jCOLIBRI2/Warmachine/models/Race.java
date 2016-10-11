package models;

import com.google.gson.annotations.SerializedName;

public enum Race {
	@SerializedName("cygnar") CYGNAR,
	@SerializedName("retribution") RETRIBUTION,
	@SerializedName("khador") KHADOR,
	@SerializedName("menoth") MENOTH,
	@SerializedName("cryx") CRYX,
	@SerializedName("convergence") CONVERGENCE,
	@SerializedName("mercs") MERCS,
	@SerializedName("minions") MINIONS,
	@SerializedName("circle") CIRCLE,
	@SerializedName("skorne") SKORNE,
	@SerializedName("legion") LEGION,
	@SerializedName("trollblood") TROLLBLOOD;
}
