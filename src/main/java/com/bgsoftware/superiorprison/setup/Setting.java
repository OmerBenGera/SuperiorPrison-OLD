package com.bgsoftware.superiorprison.setup;

import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;

public enum Setting {

    RANK_PROGRESS_BAR("rank_progress_bar.enabled"),
    RANK_PROGRESS_BAR_COLOR("rank_progress_bar.color"),
    RANK_PROGRESS_BAR_STYLE("rank_progress_bar.style");

    private Object value;

    Setting(String key) {
        value = SuperiorPrisonPlugin.getInstance().getManager().getFileManager().getSettingsYaml().getBukkitConfig().get(key);
    }

    @SuppressWarnings("unchecked")
    public <T> T getValue() {
        return (T) value;
    }
}
