package kehoachthuchi.hoang.com.kehoachthuchi.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import kehoachthuchi.hoang.com.kehoachthuchi.base.BaseModel

@Entity(tableName = "payment")
class Payment(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var title: String? = "",
    var content: String? = "",
    var time: String? = "",
    var consume: String? = "",
    var type: String? = ""
) : BaseModel()