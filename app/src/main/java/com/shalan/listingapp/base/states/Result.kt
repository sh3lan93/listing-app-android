package com.shalan.listingapp.base.states


data class Result<T>(
    val status: ICommonStatus,
    val data: T?,
    val error: String?,
    @ErrorTypes val errorType: Int?
) : IResult<T> {

    companion object {
        fun <T> loading() = Result<T>(CommonStatusImp.LOADING, null, null, null)

        fun <T> success() = Result<T>(CommonStatusImp.SUCCESS, null, null, null)

        fun <T> success(data: T?) = Result(CommonStatusImp.SUCCESS, data, null, null)

        fun <T> error(error: String?, errorType: Int?) =
            Result<T>(CommonStatusImp.ERROR, null, error, errorType)
    }

    override fun fetchData(): T? = data

    override fun fetchError(): Pair<Int, String?>? = errorType?.let {
        Pair(it, error)
    }

    override fun whichStatus(): ICommonStatus = status
}
